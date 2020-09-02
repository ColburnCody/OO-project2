package model;

import view.MenuScreen;

public class Hero {

    private int health;
    private int attack;

    public Hero(){
        String hero = MenuScreen.getHero();
        if(hero == "warrior"){
            health = 50;
            attack = 25; 
        } else if(hero == "wizard"){
            health = 40;
            attack = 35;
        } else if(hero == "ranger"){
            health = 45;
            attack = 30;
        }
    }

    public int getHealth(){
        return health;
    }
    
}
