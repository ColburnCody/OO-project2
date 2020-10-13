package model;

import java.awt.Graphics2D;
import java.util.Random;

public class Hero implements IDraw {

    protected int health;
    private int resetHealth;
    protected int attack;
    private boolean deprived;

    public Hero(int health, int attack, boolean deprived) {
        this.deprived = deprived;
        if(this.deprived == true){
            this.health = 1;
            this.health = 1;
            this.resetHealth = 1;
        }else{
            this.health = health;
            this.resetHealth = health;
            this.attack = attack;
        }

    }

    public int getHealth() {
        return health;
    }

    public boolean getDeprived(){
        return deprived;
    }

    public int getAttack() {
        int crit;
        Random rand = new Random();
        crit = rand.nextInt(6) + 1;
        if (crit == 2) {
            int critAttack = attack * 2;
            return critAttack;
        } else {
            return attack;
        }
    }

    public int combat(int x) {
        health = health - x;
        return health;
    }

    public void setHealth() {
        health = resetHealth;
    }

    @Override
    public void render(Graphics2D g2) {
    
    }
    
}
