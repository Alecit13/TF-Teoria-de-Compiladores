import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LLVMIRGenerator extends TIME_FLOWBaseVisitor<String> {

    private final StringBuilder irCode = new StringBuilder();
    private final SymbolTable symbolTable;
    
    private static final String TASK_STRUCT_NAME = "%task.struct";
    private static final long MS_IN_SECOND = 1000L;
    private static final long MS_IN_MINUTE = 60 * MS_IN_SECOND;
    private static final long MS_IN_HOUR = 60 * MS_IN_MINUTE;
    private static final long MS_IN_DAY = 24 * MS_IN_HOUR;

    public LLVMIRGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        
        // --- INICIALIZACIÓN Y METADATA ---
        irCode.append("; LLVM IR generado por TIME-FLOW Compiler (Hito 3 - Implementación Final)\n");
        irCode.append("target triple = \"x86_64-pc-windows-msvc\"\n\n"); 
        
        irCode.append("; Estructura de Tarea: { last_run_time: i64, period_ms: i64, status: i8 }\n");
        irCode.append(TASK_STRUCT_NAME).append(" = type { i64, i64, i8 }\n\n");

        // Declaraciones de funciones externas para interactuar con el Runtime C/C++
        irCode.append("declare i64 @runtime_get_time()\n"); 
        irCode.append("declare void @runtime_log_execution(ptr)\n"); // ptr para opaque pointers
        irCode.append("\n");
        
        // Generar cadenas de logging para cada tarea (Cadenas globales)
        generateGlobalStrings();
    }
    
    // Genera las cadenas estáticas de texto para el logging
    private void generateGlobalStrings() {
        for (String taskName : symbolTable.getDefinedTaskNames()) {
            // El mensaje de log que la función C imprimirá
            String logMessage = "[TASK EXECUTION] " + taskName;
            
            // Declaración de cadena global
            irCode.append(String.format("@.str.%s = private constant [%d x i8] c\"%s\\00\"\n", 
                                        taskName, logMessage.length() + 1, logMessage));
        }
        irCode.append("\n");
    }

    private long durationToMilliseconds(TIME_FLOWParser.DurationContext ctx) {
        long value = Long.parseLong(ctx.INT_LITERAL().getText());
        String unit = ctx.time_unit().getText();
        
        switch (unit) {
            case "SECONDS": return value * MS_IN_SECOND;
            case "MINUTES": return value * MS_IN_MINUTE;
            case "HOURS":   return value * MS_IN_HOUR;
            case "DAYS":    return value * MS_IN_DAY;
            default: return 0;
        }
    }
    
    public void generate(TIME_FLOWParser.ProgramContext ctx) {
        visit(ctx);
        generateMainScheduler();
    }
    
    @Override
    public String visitProgram(TIME_FLOWParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }
    
    // ==========================================================
    // Generación de Declaración de Tareas y Estado Global
    // ==========================================================
    @Override
    public String visitTask_declaration(TIME_FLOWParser.Task_declarationContext ctx) {
        String taskName = ctx.ID().getText();
        long periodMs = 0; 

        // 1. Calcular el período máximo
        for (TIME_FLOWParser.RestrictionContext restrictionCtx : ctx.task_body().restriction()) {
            if (restrictionCtx.execute_restriction() != null) {
                long currentPeriod = durationToMilliseconds(restrictionCtx.execute_restriction().duration());
                if (currentPeriod > periodMs) {
                    periodMs = currentPeriod;
                }
            }
        }
        
        // 2. Generar la función LLVM (cuerpo ejecutable de la Tarea)
        irCode.append(String.format("define void @task_%s() {\n", taskName));
        
        String logMessage = "[TASK EXECUTION] " + taskName;
        int logLength = logMessage.length() + 1;
        
        // CORRECCIÓN FINAL: Uso de 'ptr' para compatibilidad con Clang moderno (Opaque Pointers)
        // Eliminado el error de paréntesis y uso de sintaxis moderna.
        irCode.append(String.format("  %%strptr = getelementptr inbounds [%d x i8], ptr @.str.%s, i64 0, i64 0\n", 
                                    logLength, taskName));
                                    
        irCode.append("  call void @runtime_log_execution(ptr %strptr)\n");
        
        irCode.append("  ret void\n");
        irCode.append("}\n\n");
        
        // 3. Generar el dato global de la estructura
        irCode.append(String.format("@%s_state = global %s { i64 0, i64 %d, i8 0 }\n", 
                                    taskName, TASK_STRUCT_NAME, periodMs));
        
        return null;
    }

    // ==========================================================
    // Generación del Scheduler (Función Principal @main)
    // ==========================================================
    private void generateMainScheduler() {
        List<String> taskNames = symbolTable.getDefinedTaskNames();
        
        irCode.append("\n; Función Principal (Scheduler Multiagente)\n");
        irCode.append("define i32 @main() {\n");
        
        irCode.append("entry:\n");
        
        irCode.append("  ; Simulación: Bucle del scheduler\n");
        irCode.append("  %i_ptr = alloca i32\n");
        irCode.append("  store i32 0, ptr %i_ptr\n"); // ptr
        irCode.append("  br label %loop_condition\n\n");
        
        irCode.append("loop_condition:\n");
        irCode.append("  %i = load i32, ptr %i_ptr\n"); // ptr
        irCode.append("  %loop_end = icmp slt i32 %i, 100\n"); 
        irCode.append("  br i1 %loop_end, label %scheduler_loop, label %exit\n\n");
        
        irCode.append("scheduler_loop:\n");
        irCode.append("  %current_time = call i64 @runtime_get_time()\n\n");
        
        if (!taskNames.isEmpty()) {
            irCode.append(String.format("  br label %%%s\n\n", "check_" + taskNames.get(0))); 
        } else {
            irCode.append("  br label %loop_counter\n\n");
        }

        int taskIndex = 0;
        String nextTaskLabel;
        
        for (String taskName : taskNames) { 
            String checkBlock = "check_" + taskName;
            String executeBlock = "execute_" + taskName;
            
            nextTaskLabel = (taskIndex < taskNames.size() - 1) 
                            ? "check_" + taskNames.get(taskIndex + 1)
                            : "loop_counter";
            
            irCode.append(String.format("%s:\n", checkBlock));
            
            // Actualizado a sintaxis 'ptr' para Opaque Pointers
            irCode.append(String.format("  %%task_state_%d = load %%task.struct, ptr @%s_state\n", taskIndex, taskName));
            irCode.append(String.format("  %%last_run_%d = extractvalue %%task.struct %%task_state_%d, 0\n", taskIndex, taskIndex));
            
            irCode.append(String.format("  %%diff_%d = sub i64 %%current_time, %%last_run_%d\n", taskIndex, taskIndex));
            
            // GEP con ptr
            irCode.append(String.format("  %%period_ptr_%d = getelementptr inbounds %%task.struct, ptr @%s_state, i32 0, i32 1\n", taskIndex, taskName));
            irCode.append(String.format("  %%period_%d = load i64, ptr %%period_ptr_%d\n", taskIndex, taskIndex));

            irCode.append(String.format("  %%ready_%d = icmp sge i64 %%diff_%d, %%period_%d\n", taskIndex, taskIndex, taskIndex));
            
            irCode.append(String.format("  br i1 %%ready_%d, label %%%s, label %%%s\n\n", taskIndex, executeBlock, nextTaskLabel));
            
            irCode.append(String.format("%s:\n", executeBlock));
            // irCode.append(String.format("  ; Tarea: %s ejecutada\n", taskName));
            
            irCode.append(String.format("  call void @task_%s()\n", taskName));
            
            // Store con ptr
            irCode.append(String.format("  %%time_ptr_%d = getelementptr inbounds %%task.struct, ptr @%s_state, i32 0, i32 0\n", taskIndex, taskName));
            irCode.append(String.format("  store i64 %%current_time, ptr %%time_ptr_%d\n", taskIndex));

            irCode.append(String.format("  br label %%%s\n\n", nextTaskLabel));
            
            taskIndex++;
        }
        
        irCode.append("loop_counter:\n");
        irCode.append("  %i_next = add i32 %i, 1\n");
        irCode.append("  store i32 %i_next, ptr %i_ptr\n"); // ptr
        irCode.append("  br label %loop_condition\n\n"); 

        irCode.append("exit:\n");
        irCode.append("  ret i32 0\n");
        irCode.append("}\n");
    }

    public void saveIR(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(irCode.toString());
        }
    }
}