import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Random.*;
import javax.swing.*;

public class BottleGame extends JFrame{
    int screenWidth = 1000;
    int screenHeight = 1000; 
    int bottlesAmount = 6;
    String bottlesAmountStr = String.valueOf(bottlesAmount);
    int bottlesMin = 5;
    int bottlesMax = 9;
    int attempts = 0;
    //JButton b1;
    JLabel titleLabel;
    JLabel bottleAmountLabel;
    JLabel bottleAmountTxt;

    JPanel titlePanel = new JPanel();
    JPanel menuPanel = new JPanel();

    JFrame frame = new JFrame("Bottle Game");

    BottleGame(){
        //MAKE THE WINDOW
        frame.setSize(20, 20);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        //frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //SET THE BACKGROUND
        frame.setContentPane(new JLabel(new ImageIcon("src//BottleGameBG.jpg")));
        frame.setSize(500, 647);

        // frame.setLayout(new FlowLayout());
        frame.setLayout(new BorderLayout());


        //SET TEXT AND BUTTONS
        titleLabel = new JLabel("BOTTLE GAME");
        bottleAmountLabel = new JLabel("BOTTLES: ");
        bottleAmountTxt = new JLabel(bottlesAmountStr);
        bottleAmountTxt.setFocusable(false);
        bottleAmountTxt.setPreferredSize(new Dimension(10, 15));
        //b1 = new JButton("I am a button");

        
        //SET PANELS
        menuPanel.add(bottleAmountLabel);
        menuPanel.add(createScrollButton("LEFT", titleLabel));
        menuPanel.add(bottleAmountTxt);
        menuPanel.add(createScrollButton("RIGHT", titleLabel));
        menuPanel.add(createStartButton());
        menuPanel.setMaximumSize(new Dimension(500, 20));
        menuPanel.setBackground(new Color(0,0,0,0));
        menuPanel.setLayout(new FlowLayout());


        titlePanel.setBackground(Color.gray);
        titlePanel.setSize(500, 100); //<----- WORK ON LATERRRRRR
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(titleLabel, BorderLayout.CENTER); 

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(menuPanel, BorderLayout.CENTER);

        titleLabel.setFont(new Font("Serif", Font.PLAIN, 60)); 


        //image background 
        
        // JLabel background = new JLabel(new ImageIcon("*/BottleGameBG.png"));
        // add(background);
        
        // //buttons to set on background 
        // background.setLayout(new FlowLayout());
        // l1 = new JLabel("Here is a button");
        // b1 = new JButton("I am a button");
        // background.add(l1);
        // background.add(b1);

    }
    // public static void main(String[] args) {
    //     new BackgroundImageJFrame();
    // } 

    JButton createStartButton(){
        JButton start = new JButton("START");
        return start;
    }

    JButton createScrollButton(String direction, JLabel thingToChange){
        if(!direction.equals("LEFT") && !direction.equals("RIGHT")){
            throw new IllegalArgumentException("Scroll button needs to go left or right!");
        }

        JButton newButton = new JButton();
        newButton.setFocusable(false);
        newButton.setPreferredSize(new Dimension(15, 10));
        newButton.setAlignmentY(250);
        newButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(bottlesAmount > bottlesMin && direction.equals("LEFT")){
                    bottlesAmount--;
                }
                else if(bottlesAmount < bottlesMax && direction.equals("RIGHT")){
                    bottlesAmount++;
                }

                bottleAmountTxt.setText(String.valueOf(bottlesAmount));
                bottleAmountTxt.paintImmediately(bottleAmountTxt.getVisibleRect());
                System.out.println(bottlesAmount);
            }
        });

        return newButton;
    }

    Bottle[] assertBottles(int bottles){ //chooses x amount of bottle to be the correct order (the solution)  //change this to be modular when we implement options
        Bottle[] bottleOrder = new Bottle[bottlesAmount];
        ArrayList<Integer> colorNums = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++){
            colorNums.add(i);
        }

        for(int l = 0; l < bottlesAmount; l++){ 
            //RANDOMLY CHOOSES A COLOR (REPERESENTED BY A NUMBER 0-8) AND ASSIGNS IT TO THE NEW BOTTLE, 
            //THEN REMOVES THAT COLOR FROM THE LIST OF COLORS TO CHOOSE FROM
            Random rand = new Random();
            int color = rand.nextInt(9 - l);
            bottleOrder[l] = new Bottle(colorNums.get(color));
            colorNums.remove(color);
        }
        return bottleOrder;
    }

    Bottle[] randomizeBottles(Bottle[] solution){ //randomizes the bottles for the player
        int randomizeAmount = 51;
        Bottle[] randomizedBottles = Arrays.copyOf(solution, 6);
        
        for(int i = 0; i < randomizeAmount; i++){
            Random rand = new Random();
            int index1 = rand.nextInt(solution.length);
            int index2 = rand.nextInt(solution.length);
            randomizedBottles = swapBottles(randomizedBottles, index1, index2);
        }
        return randomizedBottles;
    }

    Bottle[] swapBottles(Bottle[] bottles, int bottleIndex1, int bottleIndex2){
        Bottle tempBottle = bottles[bottleIndex1];
        bottles[bottleIndex1] = bottles[bottleIndex2];
        bottles[bottleIndex2] = tempBottle;
        return bottles;
    }
}
