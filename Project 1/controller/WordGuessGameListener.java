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

    private char[] guesses;
    private String guessText;

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
            guessText = "";
            for(int i = 0; i < key; i++){
                guessText += ". ";
            }
            guesses = guessText.toCharArray();
            panel.getGuessField().setText(guessText);
            panel.getGuessField().setFont(new Font("Courier", Font.BOLD, 15));
            panel.getSolutionField().setText(answer);
            panel.getSolutionField().setFont(new Font("Courier", Font.BOLD, 15));
            panel.getSolutionField().setForeground(Color.red);
            for(var b: panel.getGuessButtons()){
                b.setEnabled(true);
            }
            panel.getCanvas().setLives(wordguess.getLives());
            panel.getCanvas().repaint();
        } else{
            button.setEnabled(false);
            char guess = button.getText().charAt(0);
            wordguess.setGuess(guess);
            boolean correct = false;
            for(int i = 0; i < wordguess.getSolution().length(); i++){
                if(wordguess.getSolution().charAt(i) == wordguess.getGuess()){
                    guesses[i] = wordguess.getGuess();
                    guessText = String.valueOf(guesses);
                    correct = true;
                }
                
                if(correct){
                    panel.getGuessField().setText(guessText);
                } else{
                    panel.getCanvas().setLives(wordguess.changeLife());
                    panel.getCanvas().repaint();
                }
            }
            }
        

    }
    
}
