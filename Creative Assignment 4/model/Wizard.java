package model;

import java.util.Random;

public class Wizard extends Hero {

    public Wizard(int health, int attack){
        super(health, attack);
    }
    
    @Override
    public int getAttack(){
        int crit;
        Random rand = new Random();
        crit = rand.nextInt(3);
        if(crit == 2){
            int critAttack = attack * 4;
            return critAttack;
        } else{
            return attack;
        }
    }
}
