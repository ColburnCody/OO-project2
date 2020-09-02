package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;

public class BattleCanvas extends JPanel{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private BattleSimulator panel;

    public BattleCanvas(BattleSimulator panel){
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        BattleSimulator.GameState state = panel.getGameState();
        if(state == BattleSimulator.GameState.READY){
            g2.setColor(Color.yellow);
            g2.setFont(new Font("Courier", Font.BOLD, 30));
            g2.drawString("Click <Fight!> to battle!", 70, 150);
        } else{
            if(state == BattleSimulator.GameState.GAMEOVER){
                if(panel.getDragon().getHealth() <= 0){
                    g2.setColor(Color.yellow);
                    g2.setFont(new Font("Courier", Font.BOLD, 30));
                    g2.drawString("You beat the dragon! Collect your reward!", 70, 150);
                    panel.getRewardButton().setEnabled(true);
                } else if(panel.getHero().getHealth() <= 0){
                    g2.setColor(Color.red);
                    g2.setFont(new Font("Courier", Font.BOLD, 30));
                    g2.drawString("You lost :(", 70, 150);
                }
            }
            
        }
    }
    
}
