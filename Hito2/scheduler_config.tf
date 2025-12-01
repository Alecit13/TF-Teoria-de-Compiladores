// scheduler_config.tf (Corregido con Tareas de Acción)

// --- Tareas de Accion (Nuevas Declaraciones) ---
// Estas tareas no tienen restricciones de tiempo, solo son invocadas por IF/DO.

TASK Log_Event {};
TASK Start_Analysis {};
TASK Send_Urgent_Alert {};

// --- Tareas de Planificación ---

TASK Sensor_Readings {
    EXECUTE EVERY 30 SECONDS;
};

TASK Data_Processing {
    // Si la lectura terminó hace más de 5 minutos, la tarea procesa.
    IF (Sensor_Readings HAS_FINISHED AFTER 5 MINUTES) DO {
        Log_Event Start_Analysis ; // Ahora referencian tareas definidas
    }; 
    
    EXECUTE EVERY 1 HOURS;
};

TASK Cleanup {
    // Si el procesamiento ha tardado más de un día, lanza una alerta.
    IF (Data_Processing HAS_FINISHED AFTER 1 DAYS) DO {
        Send_Urgent_Alert ; // Ahora referencia una tarea definida
    };
};