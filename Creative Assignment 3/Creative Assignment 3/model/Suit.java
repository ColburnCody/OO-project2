package model;

import java.awt.Color;

public class Suit extends Card{

    private String val;
    private Color color;
    
    public Suit(int x, int y, int width, int height, String val, Color color){
        super(x, y, width, height);
        this.val = val;
        this.color = color;
    }

    public String getVal() {
        return val;
    }

    public Color getColor() {
        return color;
    }


    
}
