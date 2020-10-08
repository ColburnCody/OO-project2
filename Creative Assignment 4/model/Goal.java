package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class Goal extends Shape {

    public Goal(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.yellow);
        g2.fillRect(getX(), getY(), 10, 10);
    }
    
}
