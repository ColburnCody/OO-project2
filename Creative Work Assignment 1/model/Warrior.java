package model;

public class Warrior {

    private int health;
    private int attack;
    private int defense;

    public Warrior(int h, int a, int d){
        health = h;
        attack = a;
        defense = d;
    }

    public int attk(){
        return attack;
    }
    
}