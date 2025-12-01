// Driver.java (Versión Final Hito 2: Sintaxis + Semántica + Generación IR)

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker; // Necesario para el Listener
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        // 1. Verificar el argumento de entrada
        if (args.length != 1) {
            System.err.println("Uso: java Driver <archivo_time_flow.tf>");
            return;
        }

        try {
            // 2-5. Inicialización del Parser
            String inputFilename = args[0];
            CharStream input = CharStreams.fromFileName(inputFilename);
            TIME_FLOWLexer lexer = new TIME_FLOWLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TIME_FLOWParser parser = new TIME_FLOWParser(tokens);
            
            // Suprimir la salida de error por defecto de ANTLR
            parser.removeErrorListeners();
            parser.addErrorListener(ConsoleErrorListener.INSTANCE);

            // 6. Análisis Sintáctico
            ParseTree tree = parser.program(); 

            // 7. Verificación de Errores Sintácticos
            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("❌ Errores de SINTAXIS encontrados. Se detiene el proceso.");
                return;
            }
            
            System.out.println("✅ Análisis Sintáctico Exitoso.");
            
            // --- INICIO DEL ANÁLISIS SEMÁNTICO (Hito 2 - Parte A) ---
            
            ParseTreeWalker walker = new ParseTreeWalker();
            SemanticChecker checker = new SemanticChecker();
            
            walker.walk(checker, tree); // Ejecuta las verificaciones semánticas

            if (checker.getErrors().isEmpty()) {
                System.out.println("✅ Análisis Semántico Exitoso (Referencias y tipos verificados).");
                
                // --- INICIO GENERACIÓN LLVM IR (Hito 2 - Parte B) ---
                System.out.println("\n🚀 Iniciando Generación de LLVM IR..."); 
                
                LLVMIRGenerator generator = new LLVMIRGenerator(checker.getSymbolTable());
                
                // Iniciar la generación desde la raíz del árbol
                generator.generate((TIME_FLOWParser.ProgramContext)tree);

                // --- BLOQUE CRÍTICO: ESCRITURA DE ARCHIVO ---
                String irFilename = inputFilename.replace(".tf", ".ll");
                
                try {
                    generator.saveIR(irFilename);
                    System.out.println("✅ LLVM IR generado y guardado en: " + irFilename);
                } catch (IOException e) {
                    // CAPTURA ESPECÍFICA DE ERROR DE ESCRITURA
                    System.err.println("❌ ERROR: No se pudo escribir el archivo LLVM IR.");
                    System.err.println("  -> Verifique permisos de disco o si el archivo está en uso.");
                    System.err.println("  -> Detalle: " + e.getMessage());
                }
                // --- FIN GENERACIÓN LLVM IR ---
                
                System.out.println("\n--- Árbol Sintáctico ---");
                System.out.println(tree.toStringTree(parser));

            } else {
                System.err.println("❌ Errores SEMÁNTICOS encontrados:");
                for (String error : checker.getErrors()) {
                    System.err.println(" -> " + error);
                }
            }
            
        } catch (IOException e) {
            // Captura de error de lectura de archivo
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}