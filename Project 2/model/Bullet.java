package model;

import java.awt.Graphics2D;

import model.statePattern.BulletState;
import model.statePattern.BulletStateFired;

import java.awt.Color;

public class Bullet extends GameElement {

    public static final int WIDTH = 5;
    public static final int UNIT_MOVE = 10;

    private BulletState state;

    public Bullet(int x, int y){
        super(x, y, Color.red, true, WIDTH, WIDTH*3);
        state = new BulletStateFired();
    }

    public void goNextState(){
        state.goNext(this);
    }

    public void setState(BulletState state) {
        this.state = state;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        if(filled){
            g2.fillRect(x, y, width, height);
        }else{
            g2.drawRect(x, y, width, height);
        }

    }

    @Override
    public void animate() {
        super.y -= UNIT_MOVE;
    }
    
}
