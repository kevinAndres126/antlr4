import generated.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;


/**
 *  CharStreams.fromFileName("myinputfile")
 * Created by oviquez on 25/8/2016.
 */
public class Main {
    public static void main(String[] args){


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = null;
                try {
                    frame = new GUIMonkey();
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                frame.setSize(940,570);
                frame.setVisible(true);
            }
        });

    }
}