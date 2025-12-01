#include <stdio.h>
#include <stdint.h>
#include <string.h>

// Variable global para simular el tiempo que avanza con cada ciclo del scheduler
int64_t simulated_time = 0;

/**
 * Función externa llamada por el LLVM IR para obtener el tiempo actual.
 * Devolvemos el tiempo simulado en milisegundos.
 */
int64_t runtime_get_time() {
    // Simulación: Avanzamos el tiempo para cada ciclo de verificación.
    // Esto asegura que la lógica temporal LLVM (diff >= period) se active.
    simulated_time += 1000; // Avanzamos 1 segundo por ciclo simulado
    return simulated_time;
}

/**
 * Función externa llamada por el LLVM IR para loggear la ejecución de una tarea.
 * En una implementación real, esto ejecutaría el cuerpo de la tarea.
 */
void runtime_log_execution(char *task_name) {
    printf("[RUNTIME LOG @ %lld ms] Tarea ejecutada: %s\n", 
           simulated_time, 
           task_name);
    
    fflush(stdout);
    // Aquí podrías agregar más lógica para marcar la tarea como 'FINALIZED'
}

// Nota: La función main del LLVM IR (@main) será la que llame a runtime_get_time
// y dirija el flujo del programa.