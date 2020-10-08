package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class Player extends Shape {

    public Player(int x, int y){
        super(x, y);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.blue);
        g2.fillRect(getX(), getY(), 10, 10);
    }

    
}
