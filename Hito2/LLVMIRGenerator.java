// LLVMIRGenerator.java

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import java.io.FileWriter;
import java.io.IOException;

public class LLVMIRGenerator extends TIME_FLOWBaseVisitor<String> {

    private StringBuilder irCode = new StringBuilder();
    private final SymbolTable symbolTable;
    
    // Constantes para la estructura de la Tarea (debe coincidir con el diseño)
    private static final String TASK_STRUCT_NAME = "%task.struct";
    
    public LLVMIRGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        
        // Inicialización y metadata
        irCode.append("; LLVM IR generado por TIME-FLOW Compiler (Hito 2)\n");
        irCode.append("target triple = \"x86_64-pc-windows-msvc\"\n\n");        
        // Definición de la estructura de la Tarea (i64, i64, i8)
        irCode.append("; Estructura de Tarea: { last_run_time: i64, period_ms: i64, status: i8 }\n");
        irCode.append(TASK_STRUCT_NAME).append(" = type { i64, i64, i8 }\n\n");
    }

    public void generate(TIME_FLOWParser.ProgramContext ctx) {
        // 1. Recorrer y generar declaraciones
        visit(ctx);
        
        // 2. Generar la función principal del scheduler simulado
        irCode.append("\n; Función Principal (Runtime Simulador)\n");
        irCode.append("define i32 @main() {\n");
        irCode.append("  ; Aquí se iniciaría la lógica del scheduler multiagente\n");
        irCode.append("  ret i32 0\n");
        irCode.append("}\n");
    }
    
    @Override
    public String visitProgram(TIME_FLOWParser.ProgramContext ctx) {
        // Visitar todas las declaraciones de tareas
        return visitChildren(ctx);
    }
    
    // ==========================================================
    // Generación para Declaración de Tareas y Estado Global
    // ==========================================================
    @Override
    public String visitTask_declaration(TIME_FLOWParser.Task_declarationContext ctx) {
        String taskName = ctx.ID().getText();
        
        // 1. Generar la función LLVM (cuerpo ejecutable de la Tarea)
        irCode.append(String.format("define void @task_%s() {\n", taskName));
        irCode.append(String.format("  ; Cuerpo de la tarea %s (Placeholder: llamada a función externa o lógica)\n", taskName));
        irCode.append("  ret void\n");
        irCode.append("}\n\n");
        
        // 2. Generar el dato global de la estructura para el scheduler
        // Inicialización: { last_run_time=0, period_ms=0, status=0 }
        // Nota: El periodo (period_ms) se actualizaría con un loop que recorre las restricciones.
        // Aquí solo lo inicializamos a cero, la lógica se completará en Hito 3.
        irCode.append(String.format("@%s_state = global %s { i64 0, i64 0, i8 0 }\n", taskName, TASK_STRUCT_NAME));
        
        return null;
    }
    
    // Otros métodos de visita (visitExecute_restriction, visitDuration) se completarían en Hito 3.

    // Helper para guardar el IR
    public void saveIR(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(irCode.toString());
        }
    }
}