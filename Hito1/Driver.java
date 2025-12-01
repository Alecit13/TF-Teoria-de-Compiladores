import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;

// Recuerda que esta clase usará los archivos generados por ANTLR
public class Driver {
    public static void main(String[] args) {
        // 1. Verificar el argumento de entrada
        if (args.length != 1) {
            System.err.println("Uso: java Driver <archivo_time_flow.tf>");
            return;
        }

        try {
            // 2. Crear el flujo de entrada desde el archivo (ej. scheduler_config.tf)
            CharStream input = CharStreams.fromFileName(args[0]);
            
            // 3. Crear el Léxico (Lexer) y pasarle el flujo de entrada
            TIME_FLOWLexer lexer = new TIME_FLOWLexer(input);
            
            // 4. Crear un Stream de Tokens a partir del Lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // 5. Crear el Parser con el Stream de Tokens
            TIME_FLOWParser parser = new TIME_FLOWParser(tokens);
            
            // 6. Iniciar el análisis en la regla de inicio 'program'
            // Esto construye el Árbol Sintáctico (Parse Tree)
            ParseTree tree = parser.program(); 

            // 7. Verificación: Si no hay errores, la gramática es correcta.
            if (parser.getNumberOfSyntaxErrors() == 0) {
                System.out.println("✅ Análisis Sintáctico Exitoso (TIME-FLOW)");
                System.out.println("\n--- Árbol Sintáctico Generado ---");
                // Imprimir el árbol sintáctico en formato Lisp para el demo
                System.out.println(tree.toStringTree(parser)); 
            } else {
                System.err.println("❌ Errores de Sintaxis encontrados.");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}