import generated.*;
import javax.swing.*;


/**
 *  CharStreams.fromFileName("myinputfile")
 * Created by oviquez on 25/8/2016.
 */
public class Main {
    public static void main(String[] args){


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new GUIMonkey();
                frame.setSize(1000,550);
                frame.setVisible(true);
            }
        });





    }
}