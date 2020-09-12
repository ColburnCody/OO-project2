package controller;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.WordGuessGame;
import view.WordGuessPanel;

public class WordGuessGameListener implements ActionListener{

    private WordGuessPanel panel;

    private WordGuessGame wordguess;

    private char[] letters;
    private String guess;
    private int lives;

    public WordGuessGameListener(WordGuessPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == panel.getNewButton()){
            wordguess = new WordGuessGame();
            panel.setWordGuessGame(wordguess);
            panel.setGameState(WordGuessPanel.GameState.PLAYING);
            String answer = wordguess.getSolution();
            int key = answer.length();
            guess = "";
            for(int i = 0; i < key; i++){
                guess += '.';
            }
            letters = new char[key];
            letters = guess.toCharArray();
            panel.getGuessField().setText(guess);
            panel.getGuessField().setFont(new Font("Courier", Font.BOLD, 20));
            panel.getSolutionField().setText(answer);
            panel.getSolutionField().setFont(new Font("Courier", Font.BOLD, 20));
            panel.getSolutionField().setForeground(Color.red);
            for(var b: panel.getGuessButtons()){
                b.setEnabled(true);
            }
            lives = wordguess.getLives();
            panel.getCanvas().setLives(lives);
            panel.getCanvas().repaint();
        } else{
            button.setEnabled(false);
            wordguess.setGuess(button.getText().charAt(0));
            boolean correct = false;
            for(int i = 0; i < wordguess.getSolution().length(); i++){
                if(wordguess.getSolution().charAt(i) == wordguess.getGuess()){
                    letters[i] = wordguess.getGuess();
                    correct = true;
                }               
            }
            if(correct){
                guess = String.valueOf(letters);
                panel.getGuessField().setText(guess);
                if(!guess.contains(".")){
                    panel.setGameState(WordGuessPanel.GameState.GAMEOVER);
                    panel.getCanvas().repaint();
                }
            } else{
                lives--;
                panel.getCanvas().setLives(lives);
                if(lives == 0){
                    for(var b: panel.getGuessButtons()){
                        b.setEnabled(false);
                    }
                    panel.setGameState(WordGuessPanel.GameState.GAMEOVER);
                    panel.getCanvas().repaint();
                } else{
                    panel.getCanvas().repaint();
                }
            }
            }
        

    }
    
}
