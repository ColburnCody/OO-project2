package model;

import java.util.Random;


public class Hero {

    protected int health;
    private int resetHealth;
    protected int attack;

    public Hero(int health, int attack){
        this.health = health;
        this.resetHealth = health;
        this.attack = attack;
    }

    public int getHealth(){
        return health;
    }

    public int getAttack(){
        int crit;
        Random rand = new Random();
        crit = rand.nextInt(6) + 1;
        if(crit == 2){
            int critAttack = attack * 2;
            return critAttack;
        } else{
            return attack;
        }
    }

    public int combat(int x){
        health = health - x;
        return health;
    }

    public void setHealth(){
        health = resetHealth;
    }
    
}
