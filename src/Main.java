import generated.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;


public class Main {
    public static void main(String[] args){


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = null;
                try {
                    frame = new GUIMonkey();
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    JFrame finalFrame = frame;
                    frame.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            System.exit(0);
                        }
                    });
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }

                frame.setSize(940,570);
                frame.setVisible(true);
            }
        });

    }
}