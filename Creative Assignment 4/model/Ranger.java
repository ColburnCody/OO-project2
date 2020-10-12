package model;

import java.util.Random;

public class Ranger extends Hero {

    public Ranger(int health, int attack){
        super(health, attack);
    }

    @Override
    public int combat(int x){
        Random r = new Random();
        int dodge = r.nextInt(3);
        if(dodge == 2){
            x = 0;
        } 
        health = health - x;
        return health;
    }
    
}
