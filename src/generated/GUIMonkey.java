package generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class GUIMonkey extends JFrame {
    private JPanel panel1;
    public JTextArea Code;
    private JTextArea Console;
    private JButton Run;


    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem cargarArchivo;
    private JMenuItem guardarArchivo;
    private JMenuItem salir;


    private void createUIComponents() {

    }

    public GUIMonkey(){
        super("Monkey");
        setContentPane(panel1);

        menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");
        cargarArchivo = new JMenuItem("Cargar Archivo");
        guardarArchivo = new JMenuItem("Guardar Archivo");
        salir = new JMenuItem("Salir");

        menuBar.add(archivo);
        archivo.add(cargarArchivo);
        archivo.add(guardarArchivo);
        archivo.add(salir);

        setJMenuBar(menuBar);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                System.exit(0);
            }
        });

        cargarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();

                try{
                    FileReader reader = new FileReader(filename);
                    BufferedReader br = new BufferedReader(reader);
                    Code.read(br,null);
                    br.close();
                    Code.requestFocus();

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        });

        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lexerInterprete lexer = null;
                parserInterprete parser = null;

                try {
                    //CharStream input = CharStreams.fromFileName("test.txt");
                    CharStream input = CharStreams.fromString(Code.getText());
                    lexer = new lexerInterprete(input);
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    parser = new parserInterprete(tokens);
                }
                catch(Exception e){System.out.println("No hay archivo");}

                java.util.List<Token> lista = (List<Token>) lexer.getAllTokens();

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
        });
    }
}
