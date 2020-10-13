package model;

import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;

public class Ranger extends Hero {

    public Ranger(int health, int attack, boolean deprived){
        super(health, attack, deprived);
    }

    @Override
    public int combat(int x){
        Random r = new Random();
        int dodge = r.nextInt(3);
        if(dodge == 2){
            x = 0;
        } 
        health = health - x;
        return health;
    }

    @Override
    public void render(Graphics2D g2){
        if(getDeprived() == true){
            g2.setColor(Color.gray);
            g2.drawOval(50, 50, 80, 80);
            g2.drawLine(91, 129, 91, 285);
            g2.drawLine(91, 285, 51, 368);
            g2.drawLine(91, 285, 142, 368);
            g2.drawLine(88, 181, 183, 181);
            g2.drawLine(88, 181, 11, 181);
        }else{
            g2.setColor(Color.yellow);
            g2.drawOval(50, 50, 80, 80);
            g2.drawLine(91, 129, 91, 285);
            g2.drawLine(91, 285, 51, 368);
            g2.drawLine(91, 285, 142, 368);
            g2.drawLine(88, 181, 183, 181);
            g2.drawLine(88, 181, 11, 181);
            g2.setColor(Color.white);
            g2.drawLine(188, 121, 188, 232);
            g2.setColor(Color.gray);
            g2.drawLine(188, 121, 246, 175);
            g2.drawLine(188, 232, 246, 175);
        }

    }
    
}
