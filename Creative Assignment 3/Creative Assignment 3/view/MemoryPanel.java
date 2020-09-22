package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import view.MemoryCanvas;

public class MemoryPanel {

    private JFrame window;

    public enum GameState{
            READY, PLAYING, GAMEOVER;
    }

    private GameState gameState = GameState.READY;

    private MemoryCanvas canvas;

    private JLabel highScoreLabel = new JLabel("High score");
    private JTextField highScoreDisplay = new JTextField();
    private JLabel scoreLabel = new JLabel("Current score");
    private JTextField scoreDisplay = new JTextField();

    private int highScore = 0;
    private int score = 0;


    private JButton newButton = new JButton("New game");
    private JButton clearButton = new JButton("Clear high score");
    private JRadioButton easyButton = new JRadioButton("Easy");
    private JRadioButton mediumButton = new JRadioButton("Medium");
    private JRadioButton hardButton = new JRadioButton("Hard");

    public MemoryPanel(JFrame window){
        this.window = window;
        window.setTitle("Memory Game");
    }

    public void init(){
        Container cp = window.getContentPane();

        JPanel leftPanel = new JPanel();
        canvas = new MemoryCanvas(this);
        leftPanel.add(canvas);
        cp.add(BorderLayout.WEST, leftPanel);

        JPanel northPanel = new JPanel();
        JPanel highScorePanel = new JPanel();
        JPanel scorePanel = new JPanel();
        highScorePanel.setLayout(new GridLayout(1, 2));
        scorePanel.setLayout(new GridLayout(1, 2));
        highScorePanel.add(highScoreLabel);
        highScorePanel.add(highScoreDisplay);
        scorePanel.add(scoreLabel);
        scorePanel.add(scoreDisplay);
        highScoreDisplay.setEditable(false);
        highScoreDisplay.setText(""+highScore);
        scoreDisplay.setEditable(false);
        scoreDisplay.setText(""+score);
        northPanel.add(highScorePanel);
        northPanel.add(scorePanel);
        cp.add(BorderLayout.NORTH, northPanel);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,1));
        JPanel radioPanel = new JPanel();
        ButtonGroup difficutlyGroup = new ButtonGroup();
        radioPanel.add(easyButton);
        difficutlyGroup.add(easyButton);
        radioPanel.add(mediumButton);
        difficutlyGroup.add(mediumButton);
        radioPanel.add(hardButton);
        difficutlyGroup.add(hardButton);
        TitledBorder title = BorderFactory.createTitledBorder("Select Difficulty");
        radioPanel.setBorder(title);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newButton);
        buttonPanel.add(clearButton);
        southPanel.add(radioPanel);
        southPanel.add(buttonPanel);
        cp.add(BorderLayout.SOUTH, southPanel);

    }
    
}
