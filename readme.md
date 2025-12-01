# TIME-FLOW Compiler  [Documentación del proyecto](https://docs.google.com/document/d/18AXRvSF6-K6n8vHVO33EXiWdF2eSoPxnQni1-dkehFM/edit?usp=sharing)


## Descripción del Proyecto

TIME-FLOW es un compilador para un Lenguaje Específico del Dominio (DSL) diseñado para la orquestación y automatización de tareas en sistemas de tiempo real. El lenguaje permite a los desarrolladores definir políticas de ejecución basadas en restricciones temporales estrictas (por ejemplo, periodicidad o dependencias de tiempo entre tareas) de manera declarativa, abstrayendo la complejidad de la gestión del bucle de eventos y el control de tiempo.

## Problemática y Motivación

En el desarrollo de sistemas multiagente o de automatización industrial, la implementación manual de lógica de temporización en lenguajes de propósito general (como C++ o Python) suele resultar verbosa y propensa a errores. La gestión de estados, el cálculo de diferenciales de tiempo y la sincronización entre tareas dispersa la lógica de negocio y dificulta el mantenimiento.

**TIME-FLOW** resuelve este problema proporcionando una sintaxis clara y concisa para declarar el "qué" y el "cuándo", delegando el "cómo" al compilador, el cual genera código de bajo nivel optimizado y libre de errores de sincronización manual.

## Objetivos del Proyecto

1.  **Diseño del Lenguaje:** Crear una gramática formal libre de contexto para la definición de tareas y restricciones temporales.
2.  **Análisis Semántico:** Implementar un frontend capaz de validar referencias cruzadas y tipos de datos temporales.
3.  **Generación de Código:** Traducir las construcciones de alto nivel a LLVM IR (Intermediate Representation), aprovechando la portabilidad y eficiencia del ecosistema LLVM.
4.  **Interoperabilidad:** Demostrar la integración entre el código generado (LLVM) y un entorno de ejecución nativo (C Runtime).

## Arquitectura del Compilador

El proyecto sigue una arquitectura clásica de compilador dividida en Frontend y Backend, orquestada por un controlador principal.

### 1. Frontend (Análisis)
El frontend se encarga de validar la corrección léxica, sintáctica y semántica del código fuente.

* **Lexer y Parser (ANTLR4):** Transforman el código fuente `.tf` en tokens y construyen el Árbol de Sintaxis Abstracta (AST).
* **Symbol Table (Tabla de Símbolos):** Estructura de datos que registra las definiciones de tareas para asegurar su unicidad y existencia.
* **Semantic Checker (Validación):** Un *Listener* que recorre el AST para aplicar reglas de negocio, como asegurar que una tarea referenciada en una condición `IF` haya sido declarada previamente.

### 2. Backend (Síntesis)
El backend traduce la representación intermedia validada a código máquina abstracto.

* **LLVM IR Generator:** Utiliza el patrón *Visitor* para recorrer el AST y emitir instrucciones en LLVM IR. Este componente se encarga de:
    * Traducir unidades de tiempo (minutos, horas) a una base común (milisegundos).
    * Generar las estructuras de datos globales (`struct`) para el estado de cada tarea.
    * Construir el bucle principal del *scheduler* (`@main`), inyectando la lógica de control de flujo (`br`, `icmp`) necesaria para evaluar las restricciones.

### 3. Runtime (Entorno de Ejecución)
Capa de abstracción escrita en C que permite al código LLVM interactuar con el sistema operativo.

* **Funciones Externas:** Provee implementaciones para `runtime_get_time` (simulación de reloj) y `runtime_log_execution` (salida a consola), las cuales son invocadas desde el código LLVM generado.

## Estructura del Proyecto y Archivos Clave

* `TIME_FLOW.g4`: Especificación formal de la gramática (Lexer y Parser rules).
* `Driver.java`: Punto de entrada del compilador. Coordina el análisis, chequeo semántico y la llamada al generador de código.
* `SymbolTable.java`: Gestión de metadatos y registro de identificadores de tareas.
* `SemanticChecker.java`: Lógica de validación semántica (detección de tareas no declaradas o duplicadas).
* `LLVMIRGenerator.java`: Núcleo del Backend. Contiene la lógica de traducción de AST a cadenas de texto en formato LLVM IR.
* `runtime.c`: Librería estática en C que provee funciones de E/S y simulación de tiempo.
* `scheduler_config.tf`: Archivo fuente de prueba escrito en lenguaje TIME-FLOW.

## Requisitos Previos

* **Java JDK 17+**: Para compilar y ejecutar el compilador.
* **ANTLR 4.13.x**: Herramienta para la generación del parser.
* **Clang / LLVM**: Para compilar el código intermedio `.ll` y enlazarlo con el runtime.
* **Visual Studio Build Tools (Windows)**: Necesario para las librerías base de C (`stdio.h`).

## Instrucciones de Compilación y Ejecución

Siga estos pasos para compilar el proyecto y ejecutar la validación final.

### 1. Generar Parser y Compilar el Frontend (Java)
Genera las clases reconocedoras de ANTLR y compila el código fuente del compilador.

```bash
# Generar clases Visitor y Listener desde la gramática
java -jar "ruta/a/antlr-4.13.2-complete.jar" -Dlanguage=Java -visitor TIME_FLOW.g4

# Compilar todos los archivos Java
javac -cp ".;ruta/a/antlr-4.13.2-complete.jar" *.java
```

### 2. Ejecutar el Compilador TIME-FLOW
Ejecuta el Driver pasando el archivo fuente .tf. Esto realizará el análisis y generará el archivo de código intermedio .ll.

```bash
java -cp ".;ruta/a/antlr-4.13.2-complete.jar" Driver scheduler_config.tf
```

Salida esperada: scheduler_config.ll

### 3. Compilar el Backend y Enlazar (Clang)
Utiliza clang para compilar el código intermedio generado junto con el runtime de C, produciendo un ejecutable nativo.

```bash

# Ejecutar desde Developer Command Prompt for VS
clang scheduler_config.ll runtime.c -o scheduler.exe

```

### 4. Validación (Ejecución del Scheduler)

Ejecuta el binario resultante para verificar la lógica de planificación.

```bash
.\scheduler.exe
```

## Validación de Resultados
La ejecución exitosa de scheduler.exe demuestra la correcta implementación de la cadena de compilación completa.

El output en consola mostrará logs secuenciales (ej. [RUNTIME LOG @ 30000 ms] Tarea ejecutada...) que validan:

1. Precisión Temporal: Las tareas se ejecutan exactamente cuando el contador de tiempo simulado cumple la condición diff >= period.

2. Control de Flujo: El bucle infinito generado en LLVM IR itera correctamente sobre la lista de tareas.

3. Integración de Sistemas: Las llamadas a funciones nativas (C) desde el código gestionado (LLVM) funcionan correctamente, manejando punteros y memoria de forma segura.