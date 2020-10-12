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

    private Color heroColor;
    private String heroString = MenuScreen.getHero();

    private BattleSimulator panel;

    public BattleCanvas(BattleSimulator panel){
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        if(heroString == "warrior"){
            heroColor = Color.red;
        } else if(heroString == "wizard"){
            heroColor = Color.blue;
        } else if(heroString == "ranger"){
            heroColor = Color.yellow;
        }
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
                    g2.drawString("You beat the dragon!", 70, 150);
                    g2.drawString("Collect your reward!", 90, 190);
                } else if(panel.getHero().getHealth() <= 0){
                    g2.setColor(Color.red);
                    g2.setFont(new Font("Courier", Font.BOLD, 30));
                    g2.drawString("You lost :(", 70, 150);
                    
                }
            }
            g2.setColor(heroColor);
            g2.drawOval(50, 50, 80, 80);
            g2.drawLine(91, 129, 91, 285);
            g2.drawLine(91, 285, 51, 368);
            g2.drawLine(91, 285, 142, 368);
            g2.drawLine(88, 181, 183, 181);
            g2.drawLine(88, 181, 11, 181);
            if(heroString == "warrior"){
                g2.setColor(Color.yellow);
                g2.drawLine(186, 202, 186, 168);
                g2.setColor(Color.white);
                g2.drawLine(168, 164, 204, 168);
                g2.setColor(Color.gray);
                g2.drawLine(186, 168, 193, 47);
            } else if(heroString == "wizard"){
                g2.setColor(Color.magenta);
                g2.drawLine(29, 50, 155, 50);
                g2.drawLine(58, 50, 83, 5);
                g2.drawLine(83, 5, 129, 50);
                g2.setColor(Color.gray);
                g2.drawLine(188, 317, 188, 57);
                g2.setColor(Color.white);
                g2.fillOval(173, 57, 20, 20);
            }else if(heroString == "ranger"){
                g2.setColor(Color.white);
                g2.drawLine(188, 121, 188, 232);
                g2.setColor(Color.gray);
                g2.drawLine(188, 121, 246, 175);
                g2.drawLine(188, 232, 246, 175);
            }
            g2.setColor(Color.green);
            g2.fillOval(354, 20, 100, 100);
            g2.drawLine(423, 115, 499, 164);
            g2.drawLine(357, 52, 288, 87);
            g2.drawLine(288, 87, 361, 79);
            g2.drawLine(361, 79, 321, 131);
            g2.drawLine(321, 131, 391, 110);
            g2.setColor(Color.yellow);
            g2.setFont(new Font("Courier", Font.BOLD, 15));
            g2.drawString("Click spacebar to battle the dragon!", 103, 422);
            
            
        }
    }
    
}
