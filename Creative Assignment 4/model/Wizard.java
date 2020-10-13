package model;

import java.util.Random;

import java.awt.Graphics2D;
import java.awt.Color;

public class Wizard extends Hero {

    public Wizard(int health, int attack, boolean deprived){
        super(health, attack, deprived);
    }
    
    @Override
    public int getAttack(){
        int crit;
        Random rand = new Random();
        crit = rand.nextInt(3);
        if(crit == 2){
            int critAttack = attack * 4;
            return critAttack;
        } else{
            return attack;
        }
    }

    @Override
    public void render(Graphics2D g2) {
        if(getDeprived() == true){
            g2.setColor(Color.gray);
            g2.drawOval(50, 50, 80, 80);
            g2.drawLine(91, 129, 91, 285);
            g2.drawLine(91, 285, 51, 368);
            g2.drawLine(91, 285, 142, 368);
            g2.drawLine(88, 181, 183, 181);
            g2.drawLine(88, 181, 11, 181);
        }else{
            g2.setColor(Color.blue);
            g2.drawOval(50, 50, 80, 80);
            g2.drawLine(91, 129, 91, 285);
            g2.drawLine(91, 285, 51, 368);
            g2.drawLine(91, 285, 142, 368);
            g2.drawLine(88, 181, 183, 181);
            g2.drawLine(88, 181, 11, 181);
            g2.setColor(Color.magenta);
            g2.drawLine(29, 50, 155, 50);
            g2.drawLine(58, 50, 83, 5);
            g2.drawLine(83, 5, 129, 50);
            g2.setColor(Color.gray);
            g2.drawLine(188, 317, 188, 57);
            g2.setColor(Color.white);
            g2.fillOval(173, 57, 20, 20);
        }

    }
    
}
