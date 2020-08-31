package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BaseballGamePanel {

    private JFrame window;
    private BaseballCanvas canvas;

    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] digitButtons;
    private JButton playButton = new JButton("Play Ball");
    private JButton exitButton = new JButton("Exit");

    public BaseballGamePanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("Secret Game Key: "));
        northPanel.add(gameKeyField);
        gameKeyField.setEditable(false);
        northPanel.add(new JLabel("Your guess: "));
        northPanel.add(guessField);
        guessField.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new BaseballCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);
    }
    
}