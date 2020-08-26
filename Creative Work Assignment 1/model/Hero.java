package model;

import java.util.Random;

public class Hero {

    private int health;
    private int attack;

    public Hero(int x){
        if(x == 0){
            health = 50;
            attack = 25;
        } else if(x == 1){
            health = 40;
            attack = 35;
        } else{
            health = 45;
            attack = 30;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAttack(){
        int crit;
        Random rand = new Random();
        crit = rand.nextInt(6) + 1;
        if(crit == 2){
            int critAttack = attack * 2;
            return critAttack;
        }
        else{
            return attack;
        }
    }
    
    public int combat(int x){
        health = health - x;
        return health;
    }
}