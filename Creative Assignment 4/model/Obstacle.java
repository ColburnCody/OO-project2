package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class Obstacle extends Shape {

    private int height;
    private int width;

    public Obstacle(int x, int y, int height, int width){
        super(x, y);
        this.height = height;
        this.width = width;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.fillRect(getX(), getY(), height, width);
    }

    @Override
    public void translate(int dx, int dy) {
        // TODO Auto-generated method stub

    }
    
    
}
