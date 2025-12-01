// Hito 2 - Artefacto de Análisis Semántico
// SymbolTable.java

import java.util.HashMap;
import java.util.Map;

/**
 * Registra todas las tareas declaradas en el código TIME-FLOW.
 * Para el Hito 2, solo necesitamos saber si la tarea existe.
 */
public class SymbolTable {
    // Usamos un HashMap para mapear el nombre de la tarea (String) a un booleano
    // El booleano podría indicar si la tarea fue definida, o su tipo.
    private final Map<String, Boolean> taskMap = new HashMap<>();
    
    /**
     * Registra una nueva tarea.
     * @param taskName El ID de la tarea.
     */
    public void defineTask(String taskName) {
        if (taskMap.containsKey(taskName)) {
            // Manejo de error semántico (tarea duplicada)
            System.err.println("Error Semántico: Tarea duplicada detectada: " + taskName);
        }
        taskMap.put(taskName, true);
    }
    
    /**
     * Verifica si una tarea ha sido definida previamente.
     * @param taskName El ID de la tarea a buscar.
     * @return true si la tarea existe, false si no.
     */
    public boolean taskExists(String taskName) {
        return taskMap.containsKey(taskName);
    }
}