package generated;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class GUIMonkey extends JFrame {
    private JPanel panel1;
    private JTextArea Code;
    private JTextArea ConsoleM;
    private JButton Run;
    private JLabel positionLbl;


    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem cargarArchivo;
    private JMenuItem guardarArchivo;
    private JMenuItem salir;


    private void createUIComponents() {

    }

    public GUIMonkey() throws BadLocationException {
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

        guardarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)  {

                try{
                    whenWriteStringUsingBufferedWritter_thenCorrect ();
                }catch (Exception e){
                    System.out.println("Error Archivo");
                }

            }

            public void whenWriteStringUsingBufferedWritter_thenCorrect()
                    throws IOException {
                        String str = Code.getText();
                        String fileName = JOptionPane.showInputDialog(null,"Nombre para Archivo:");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                        writer.write(str);
                        writer.close();
            }

        });

        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)  {
                lexerInterprete lexer;
                parserInterprete parser = null;
                ConsoleM.setText("");

                try {
                    CharStream input = CharStreams.fromString(Code.getText());
                    lexer = new lexerInterprete(input);

                    lexer.removeErrorListeners();
                    lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    parser = new parserInterprete(tokens);

                    parser.removeErrorListeners();
                    parser.addErrorListener(ThrowingErrorListener.INSTANCE);


                }
                catch(Exception e){ System.out.println("No hay archivo\n"); }


                try {
                    ParseTree tree = parser.program();
                    List<String> errors = ThrowingErrorListener.INSTANCE.getErrorMessages();

                    if(!errors.isEmpty()) {
                        ConsoleM.append("Compilación Fallida!!\n");

                        for (String err : errors) {
                            ConsoleM.append(err.toString() + "\n");
                        }
                    }
                    else {
                        ConsoleM.append("Compilación Exitosa!!\n");
                    }

                    Future<JFrame> treeGUI = Trees.inspect(tree,parser);

                    treeGUI.get(40000, TimeUnit.MICROSECONDS).setVisible(true);

                }
                catch(RecognitionException e){ }
                catch (InterruptedException e) { }
                catch (ExecutionException e) { }
                catch (TimeoutException e) { }
            }
        });

        Code.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Code.addCaretListener(new CaretListener() {
                    @Override
                    public void caretUpdate(CaretEvent e) {
                        int pos = Code.getCaretPosition();
                        int row = 0;
                        try {
                            row = Code.getLineOfOffset(pos);
                        } catch (BadLocationException e1) { }

                        int column = 0;
                        try {
                            column = pos - Code.getLineStartOffset(row);
                        } catch (BadLocationException e1) { }

                        positionLbl.setText(String.valueOf(row + 1) + ":" + String.valueOf(column - 1));
                    }
                });

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
