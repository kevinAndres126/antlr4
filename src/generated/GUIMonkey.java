package generated;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import java.awt.event.*;
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

    private static String ultimaDireccion = null;


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

        salir.addActionListener(actionEvent -> {
            dispose();
            System.exit(0);
        });

        cargarArchivo.addActionListener(actionEvent -> {

            JFileChooser fc = getFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                setUltimaDireccion(fc.getSelectedFile());
                File f = fc.getSelectedFile();
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

        Code.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Code.addCaretListener(e12 -> {
                    int pos = Code.getCaretPosition();
                    int row = 0;
                    try {
                        row = Code.getLineOfOffset(pos);
                    } catch (BadLocationException e1) { }

                    int column = 0;
                    try {
                        column = pos - Code.getLineStartOffset(row);
                    } catch (BadLocationException e1) { }

                    positionLbl.setText("Posición  => " + String.valueOf(row + 1) + ":" + String.valueOf(column));
                });

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        Code.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Code.addCaretListener(e13 -> {
                    int pos = Code.getCaretPosition();
                    int row = 0;
                    try {
                        row = Code.getLineOfOffset(pos);
                    } catch (BadLocationException e1) { }

                    int column = 0;
                    try {
                        column = pos - Code.getLineStartOffset(row);
                    } catch (BadLocationException e1) { }

                    positionLbl.setText("Posición => " + String.valueOf(row + 1) + ":" + String.valueOf(column));
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Run.addActionListener(e -> {

            ConsoleM.setText("");

            lexerInterprete lexer;
            parserInterprete parser = null;
            CharStream input = null;
            ParseTree tree;

            try {
                input = CharStreams.fromString(Code.getText());
            }catch (Exception ex) {
                System.out.println("No hay archivo\n");
            }

            lexer = new lexerInterprete(input);

            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new parserInterprete(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            tree = parser.program();
            List<String> errors = ThrowingErrorListener.INSTANCE.getErrorMessages();

            if(errors.isEmpty()) {
                ConsoleM.append("Compilación Exitosa!!\n");
            }
            else if(!errors.isEmpty()){
                ConsoleM.append("Compilación Fallida!!\n");

                for (String err : errors) {
                    ConsoleM.append(err + "\n");
                }
            }

            Future<JFrame> treeGUI = Trees.inspect(tree,parser);

            try {
                treeGUI.get(50000, TimeUnit.MICROSECONDS).setVisible(true);
            }
            catch (InterruptedException e1) { }
            catch (ExecutionException e1) { }
            catch (TimeoutException e1) { }

            errors.clear();

        });



    }

    public static JFileChooser getFileChooser() {
        if(ultimaDireccion != null) {
            JFileChooser fileChooser = new JFileChooser(ultimaDireccion);
            return fileChooser;
        } else {
            JFileChooser fileChooser = new JFileChooser();
            return fileChooser;
        }
    }

    public static void setUltimaDireccion(File archivo) {
        ultimaDireccion = archivo.getParent();
    }

}
