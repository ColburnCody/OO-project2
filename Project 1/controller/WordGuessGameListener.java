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
            String guess = "";
            for(int i = 0; i < key; i++){
                guess += "_ ";
            }
            panel.getGuessField().setText(guess);
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
            String guess = button.getText();
            wordguess.setGuess(guess);
            }
        

    }
    
}
