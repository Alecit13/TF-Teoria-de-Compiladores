// scheduler_config.tf (Corregido para la Regla action_body: ID+ SEMI)

// Definición de Tarea de Lectura de Sensores
TASK Sensor_Readings {
    EXECUTE EVERY 30 SECONDS;
};

// Definición de Tarea de Procesamiento de Datos
TASK Data_Processing {
    // Si la lectura terminó hace más de 5 minutos, la tarea procesa.
    IF (Sensor_Readings HAS_FINISHED AFTER 5 MINUTES) DO {
        Log_Event Start_Analysis ; // A) La lista de IDs, seguida de UN SOLO SEMI
    }; // B) El punto y coma de cierre de todo el bloque IF

    // También se ejecuta una vez cada hora, sin importar las condiciones.
    EXECUTE EVERY 1 HOURS;
};

TASK Cleanup {
    // Si el procesamiento ha tardado más de un día, lanza una alerta.
    IF (Data_Processing HAS_FINISHED AFTER 1 DAYS) DO {
        Send_Urgent_Alert ; // C) La acción, seguida de UN SOLO SEMI
    };
};