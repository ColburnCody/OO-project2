package model;

import java.util.Random;

public class Warrior {

    private int health = 50;
    private int attack = 20;

    public int getHealth() {
        return health;
    }

    public int getAttack(){
        int crit;
        Random rand = new Random();
        crit = rand.nextInt(4) + 1;
        if(crit == 2){
            int critAttack = attack * 2;
            return critAttack;
        }
        else{
            return attack;
        }
    }
    
}