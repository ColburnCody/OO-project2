package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.WordGuessGame;

public class WordGuessPanel {
    
    public enum GameState {
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private JTextField solutionField = new JTextField();
    private JTextField answerField = new JTextField();

    private WordGuessCanvas canvas;

    private WordGuessGame wordguessgame;

    private GameState gameState = GameState.READY;


    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h",
        "i", "j", "k", "l", "m", "n", "o", "p", "q",
        "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private JButton[] guessButtons;
    private JButton newButton = new JButton("New");


    public WordGuessPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(solutionField);
        solutionField.setEditable(false);
        northPanel.add(answerField);
        answerField.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new WordGuessCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));
        ButtonGroup letterGroup = new ButtonGroup();
        guessButtons = new JButton[26];
        for(int i = 0; i < 26; i++){
            guessButtons[i] = new JButton(letters[i]);
            guessButtons[i].setEnabled(false);
            letterGroup.add(guessButtons[i]);
            southPanel.add(guessButtons[i]);
        }
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);

    }

}
