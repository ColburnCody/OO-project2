package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WordGuessCanvas extends JPanel {
    
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private int lives;
    private String message;

    private WordGuessPanel panel;

    public WordGuessCanvas(final WordGuessPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        WordGuessPanel.GameState state = panel.getGameState();
        if(state == WordGuessPanel.GameState.READY){
            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier", Font.BOLD, 30));
            g2.drawString("Press <New> to Start", 90, 90);
        } else{
            if(state == WordGuessPanel.GameState.GAMEOVER){
                g2.clearRect(0, 0, WIDTH, HEIGHT);
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier", Font.BOLD, 30));
                if(lives == 0){
                    message = "YOU LOST ! ! !";
                } else if(lives != 0){
                    message = "YOU WON ! ! !";
                }
                g2.drawString(message, 90, 40);
                g2.setColor(Color.blue);
                g2.setFont(new Font("Courier", Font.BOLD, 30));
                g2.drawString("Press <New> to Start", 90, 90);
            } else{
                g2.setColor(Color.blue);
                g2.setFont(new Font("Courier", Font.BOLD, 60));
                g2.drawString("Health Level", 20, 150);
                for(int i = 0; i < lives; i++){
                    g2.fillRect(i * 70 + 20, 190, 50, 50);
                }
            }
        }
    }

    public void setLives(int lives){
        this.lives = lives;
    }

}
