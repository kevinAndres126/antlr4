import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;


/**
 *  CharStreams.fromFileName("myinputfile")
 * Created by oviquez on 25/8/2016.
 */
public class Main {
    public static void main(String[] args){
        lexerInterprete lexer = null;
        parserInterprete parser = null;

        try {
            CharStream input = CharStreams.fromFileName("test.txt");
            lexer = new lexerInterprete(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new parserInterprete(tokens);
        }
        catch(Exception e){System.out.println("No hay archivo");}

        List<Token> lista = (List<Token>) lexer.getAllTokens();

        for (Token t : lista)
            System.out.println(t.getType() + ":" + t.getText() + "\n");

        lexer.reset();

        try {
            ParseTree tree = parser.program();
            System.out.println("Compilación Exitosa!!\n");

            //System.out.println(tree.toStringTree(parser));
            //PrettyPrint printVisitor = new PrettyPrint();
            //printVisitor.visit(tree);
            //AContextual acVisitor = new AContextual();
            //acVisitor.visit(tree);
           // acVisitor.tabla.imprimir();

        }
        catch(RecognitionException e){
            System.out.println("Compilación Fallida!!");
        }

    }
}