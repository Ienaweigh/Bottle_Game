import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BackgroundImageJFrame extends JFrame{
    JButton b1;
    JLabel l1;
        public BackgroundImageJFrame(){
            setTitle("Background color for JFrame");
            setSize(400,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);

            setLayout(new BorderLayout());
            JLabel background = new JLabel(new ImageIcon());
        }

}