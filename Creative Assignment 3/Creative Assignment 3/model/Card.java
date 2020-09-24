package model;

import java.awt.Graphics2D;
import java.awt.Color;

public abstract class Card {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color cardColor;

    public Card(int x, int y, int width, int height, Color cardColor){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cardColor = cardColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getCardColor() {
        return cardColor;
    }
    
    public abstract void render(Graphics2D g2);
    
}
