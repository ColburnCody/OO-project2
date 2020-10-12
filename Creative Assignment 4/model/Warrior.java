package model;

public class Warrior extends Hero{
    private int armor;

    public Warrior(int health, int attack, int armor){
        super(health, attack);
        this.armor = armor;
    }

    @Override
    public int combat(int x){
        health = (health + armor) - x;
        return health;
    }
    
}
