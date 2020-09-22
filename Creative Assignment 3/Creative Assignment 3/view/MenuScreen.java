package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class MenuScreen {

    private JFrame window;

    private JRadioButton easyButton = new JRadioButton("Easy");
    private JRadioButton mediumButton = new JRadioButton("Medium");
    private JRadioButton hardButton = new JRadioButton("Hard");
    private JButton startButton = new JButton("Start");

    public MenuScreen(JFrame window){
        this.window = window;
        window.setTitle("Memory game");
    }
    
    public void init(){
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        JPanel radioPanel = new JPanel();
        ButtonGroup difficultyGroup = new ButtonGroup();
        radioPanel.add(easyButton);
        difficultyGroup.add(easyButton);
        radioPanel.add(mediumButton);
        difficultyGroup.add(mediumButton);
        radioPanel.add(hardButton);
        difficultyGroup.add(hardButton);
        TitledBorder title = BorderFactory.createTitledBorder("Choose difficulty");
        radioPanel.setBorder(title);
        northPanel.add(BorderLayout.CENTER, radioPanel);
        cp.add(BorderLayout.NORTH, northPanel);
        
        JPanel southPanel = new JPanel();
        southPanel.add(startButton);
        cp.add(BorderLayout.SOUTH, southPanel);
    }
}
