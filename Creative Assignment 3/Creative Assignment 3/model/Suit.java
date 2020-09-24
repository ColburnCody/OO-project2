package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Suit extends Card{

    private String val;
    private Color suitColor;
    
    public Suit(int x, int y, int width, int height, String val, Color suitColor, Color cardColor){
        super(x, y, width, height, cardColor);
        this.val = val;
        this.suitColor = suitColor;
    }

    public String getVal() {
        return val;
    }

    public Color getColor() {
        return suitColor;
    }

    @Override
    public void render(Graphics2D g2){
        g2.setColor(super.getCardColor());
        g2.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }


    
}
