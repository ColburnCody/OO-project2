package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WordGuessGameListener;
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


    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
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
        WordGuessGameListener listener = new WordGuessGameListener(this);
        guessButtons = new JButton[26];
        for(int i = 0; i < 26; i++){
            guessButtons[i] = new JButton("" + letters[i]);
            guessButtons[i].setEnabled(false);
            guessButtons[i].addActionListener(listener);
            letterGroup.add(guessButtons[i]);
            southPanel.add(guessButtons[i]);
        }
        newButton.addActionListener(listener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);

    }

    public WordGuessGame getWordGuessGame(){
        return wordguessgame;
    }

    public void setWordGuessGame(WordGuessGame game){
        this.wordguessgame = game;
    }

    public JFrame getWindow(){
        return window;
    }

    public WordGuessCanvas getCanvas(){
        return canvas;
    }

    public JTextField getSolutionField(){
        return solutionField;
    }

    public JTextField getGuessField(){
        return answerField;
    }

    public JButton[] getGuessButtons(){
        return guessButtons;
    }

    public JButton getNewButton(){
        return newButton;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }



}
