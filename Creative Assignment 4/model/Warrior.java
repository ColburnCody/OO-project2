package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class Warrior extends Hero{
    private int armor;

    public Warrior(int health, int attack, int armor, boolean deprived){
        super(health, attack, deprived);
        if(deprived == true){
            this.armor = 1;
        }else{
            this.armor = armor;
        }
    }

    @Override
    public int combat(int x){
        health = (health + armor) - x;
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
            g2.setColor(Color.red);
            g2.drawOval(50, 50, 80, 80);
            g2.drawLine(91, 129, 91, 285);
            g2.drawLine(91, 285, 51, 368);
            g2.drawLine(91, 285, 142, 368);
            g2.drawLine(88, 181, 183, 181);
            g2.drawLine(88, 181, 11, 181);
            g2.setColor(Color.yellow);
            g2.drawLine(186, 202, 186, 168);
            g2.setColor(Color.white);
            g2.drawLine(168, 164, 204, 168);
            g2.setColor(Color.gray);
            g2.drawLine(186, 168, 193, 47);
        }
    }
}
