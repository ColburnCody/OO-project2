package Test;

import model.Coin;

public class PiggyBankTest {

    public static void main(String[] args){
        Coin c1 = new Coin(5);
        assert c1.getValue() == 5;

        Coin c2 = new Coin(10);
        assert c2.getValue() == 10;
    }
    
}