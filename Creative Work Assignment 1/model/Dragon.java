package model;

public class Dragon {
    private int health = 75;
    private int attack = 25;

    public int getHealth(){
        return health;
    }

    public int getAttack(){
        return attack;
    }

    public int combat(int x){
        health = health - x;
        return health;
    }
}