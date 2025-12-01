// Hito 2 - Artefacto de Análisis Semántico
// SemanticChecker.java

import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.List;

// Importa las clases generadas por ANTLR
// Asegúrate de que las rutas son correctas si usas paquetes.
// import generated.*; 

public class SemanticChecker extends TIME_FLOWBaseListener {
    
    private final SymbolTable symbolTable = new SymbolTable();
    private final List<String> errors = new ArrayList<>();
    
    // Método para obtener los errores al finalizar el recorrido
    public List<String> getErrors() {
        return errors;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    // ==========================================================
    // VERIFICACIÓN 1: Declaración de Tareas (Registro)
    // ==========================================================
    
    @Override
    public void enterTask_declaration(TIME_FLOWParser.Task_declarationContext ctx) {
        // Obtenemos el ID de la tarea (el primer ID en el contexto)
        String taskName = ctx.ID().getText();
        
        // El SymbolTable maneja el error de duplicidad, pero lo registramos aquí también.
        if (symbolTable.taskExists(taskName)) {
            errors.add(String.format("Línea %d: Tarea duplicada '%s'.", 
                                      ctx.start.getLine(), taskName));
        } else {
            symbolTable.defineTask(taskName);
        }
    }

    // ==========================================================
    // VERIFICACIÓN 2: Referencia de Tareas en Condiciones
    // ==========================================================
    
    @Override
    public void exitTemporal_condition(TIME_FLOWParser.Temporal_conditionContext ctx) {
        // En una condición temporal (ej. IF (Task_A HAS_FINISHED...))
        // Obtenemos el nombre de la tarea referenciada (Task_A)
        String referencedTask = ctx.task_ref().ID().getText();
        
        if (!symbolTable.taskExists(referencedTask)) {
            errors.add(String.format("Línea %d: Error de Referencia. La tarea '%s' en la condición 'HAS_FINISHED' no ha sido definida.", 
                                      ctx.start.getLine(), referencedTask));
        }
    }

    // ==========================================================
    // VERIFICACIÓN 3: Referencia de Tareas en Bloque de Acciones
    // ==========================================================
    
    @Override
    public void exitAction_body(TIME_FLOWParser.Action_bodyContext ctx) {
        // En el bloque DO { Action1 Action2; }
        // Verificamos que todas las acciones (que son tareas ID) existan.
        
        // La regla action_body es ID+ SEMI
        // ctx.ID() devuelve una lista de todos los IDs
        for (ParseTree node : ctx.ID()) {
            String actionName = node.getText();
            
            if (!symbolTable.taskExists(actionName)) {
                errors.add(String.format("Línea %d: Error de Acción. La tarea/acción '%s' llamada en el bloque DO no ha sido definida.", 
                                          ctx.start.getLine(), actionName));
            }
        }
    }
    
    // NOTA: Para el Hito 2 se omite la "Verificación 4: Tipos Temporales" 
    // y la "Verificación 5: Restricciones Mínimas" por simplicidad del Listener base.
    // (Estas requerirían guardar más información en la SymbolTable).
}