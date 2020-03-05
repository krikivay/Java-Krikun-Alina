import graphics.MainWindow;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String args[]) {
        MainWindow frame = new MainWindow("Arithmetic operations");
        frame.setPreferredSize(new Dimension(900,400));
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }
}