package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class Dragon implements IDraw {

    private int health = 75;
    private int attack = 25;

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int combat(int x) {
        health = health - x;
        return health;
    }

    public void setHealth() {
        health = 75;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.green);
        g2.fillOval(354, 20, 100, 100);
        g2.drawLine(423, 115, 499, 164);
        g2.drawLine(357, 52, 288, 87);
        g2.drawLine(288, 87, 361, 79);
        g2.drawLine(361, 79, 321, 131);
        g2.drawLine(321, 131, 391, 110);

    }
    
}
