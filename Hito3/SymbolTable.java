import java.util.HashMap;
import java.util.Map;
import java.util.Set; // Importar Set
import java.util.List;
import java.util.ArrayList;

/**
 * Registra todas las tareas declaradas en el código TIME-FLOW.
 * Para el Hito 3, permite obtener la lista de todas las tareas definidas
 * para que el generador de código LLVM pueda iterar sobre ellas.
 */
public class SymbolTable {
    
    // Almacenamos el nombre de la tarea (clave) y un booleano (valor) 
    // indicando que está definida.
    private final Map<String, Boolean> taskMap = new HashMap<>();
    
    /**
     * Registra una nueva tarea.
     * @param taskName El ID de la tarea.
     */
    public void defineTask(String taskName) {
        if (taskMap.containsKey(taskName)) {
            // Manejo de error semántico (tarea duplicada)
            // Ya es manejado por SemanticChecker, pero lo mantenemos aquí
        }
        taskMap.put(taskName, true);
    }
    
    /**
     * Verifica si una tarea ha sido definida previamente.
     */
    public boolean taskExists(String taskName) {
        return taskMap.containsKey(taskName);
    }

    /**
     * [NUEVO MÉTODO PARA HITO 3]
     * Devuelve una lista con los nombres (IDs) de todas las tareas definidas.
     * Esto es crucial para que el LLVMIRGenerator sepa qué bucles y structs generar.
     */
    public List<String> getDefinedTaskNames() {
        return new ArrayList<>(taskMap.keySet());
    }
}