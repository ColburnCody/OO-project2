package model;

import java.util.Random;

import view.MenuScreen;

public class Hero {

    private int health;
    private int resetHealth;
    private int attack;

    public Hero(){
        String hero = MenuScreen.getHero();
        if(hero == "warrior"){
            health = 50;
            resetHealth = 50;
            attack = 25; 
        } else if(hero == "wizard"){
            health = 40;
            resetHealth = 40;
            attack = 35;
        } else if(hero == "ranger"){
            health = 45;
            resetHealth = 45;
            attack = 30;
        }
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
