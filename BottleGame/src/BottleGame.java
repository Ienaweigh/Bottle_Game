import java.awt.*;
import java.awt.event.*;
import java.util.Random.*;
import javax.swing.*;

public class BottleGame {
    int screenWidth = 700;
    int screenHeight = 750; 

    JFrame frame = new JFrame("Bottle Game");

    BottleGame(){
        frame.setVisible(true);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }
}
