grammar TIME_FLOW;

// -------------------------------------------------------------------
// PARSER RULES (Reglas Sintácticas)
// -------------------------------------------------------------------

// Punto de entrada: Un programa es una secuencia de declaraciones de tareas.
program
    : task_declaration* EOF
    ;

// Declaración de una Tarea: 'TASK' ID '{' cuerpo '}' ';'
task_declaration
    : TASK ID LBRACE task_body RBRACE SEMI
    ;

// Cuerpo de la Tarea: Contiene cero o más restricciones temporales.
// CORRECCIÓN HITO 2: Cambiado de restriction+ (uno o más) a restriction* (cero o más)
task_body
    : restriction* // <-- ¡CORRECCIÓN CLAVE! Permite tareas vacías como TASK Log_Event {};
    ;

// Una restricción puede ser periódica (EXECUTE) o condicional (IF).
restriction
    : execute_restriction
    | conditional_restriction
    ;

// 1. RESTRICCIÓN PERIÓDICA (Execute Every)
// Ejemplo: EXECUTE EVERY 30 SECONDS;
execute_restriction
    : EXECUTE EVERY duration SEMI
    ;

// 2. RESTRICCIÓN CONDICIONAL (If... Do...)
// Ejemplo: IF (Sensor_Readings HAS_FINISHED AFTER 5 MINUTES) DO { TaskA TaskB ; };
conditional_restriction
    : IF LPAREN temporal_condition RPAREN DO LBRACE action_body RBRACE SEMI
    ;

// Condición Temporal: Referencia a una tarea + estado + duración.
temporal_condition
    : task_ref HAS_FINISHED AFTER duration
    // Más adelante se agregarán: HAS_STARTED, HAS_FAILED, etc.
    ;

// Referencia a una tarea (simplemente su ID)
task_ref
    : ID
    ;

// Bloque de acciones a ejecutar (ej. llamar a otras tareas)
// Simplificado a una lista de IDs (nombres de tareas)
action_body
    : ID+ SEMI
    ;

// Definición de un valor de Tiempo
duration
    : INT_LITERAL time_unit
    ;

// Unidades de tiempo permitidas.
time_unit
    : MINUTES
    | SECONDS
    | HOURS
    | DAYS
    ;

// -------------------------------------------------------------------
// LEXER RULES (Tokens)
// -------------------------------------------------------------------

// PALABRAS CLAVE
TASK : 'TASK' ;
EXECUTE : 'EXECUTE' ;
EVERY : 'EVERY' ;
IF : 'IF' ;
DO : 'DO' ;
HAS_FINISHED : 'HAS_FINISHED' ;
AFTER : 'AFTER' ;

// UNIDADES DE TIEMPO
MINUTES : 'MINUTES' ;
SECONDS : 'SECONDS' ;
HOURS : 'HOURS' ;
DAYS : 'DAYS' ;

// SÍMBOLOS
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LBRACE : '{' ;
RBRACE : '}' ;

// LITERALES Y IDENTIFICADORES
// ID: Nombres de tareas y referencias (Ej. Monitorizar_Sistema)
ID : [a-zA-Z] ([a-zA-Z0-9_])* ;
// INT_LITERAL: Duración como números enteros (Ej. 5 en 5 MINUTES)
INT_LITERAL : [0-9]+ ;

// ESPACIOS Y COMENTARIOS (Ignorados)
WS : [ \t\r\n]+ -> skip ;
COMMENT : '//' .*? '\n' -> skip ;
LINE_COMMENT : '/*' .*? '*/' -> skip ;