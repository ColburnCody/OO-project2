package model;

import java.util.ArrayList;
import java.util.Random;

public class WordGuessGame {

    public ArrayList<String> solutions = new ArrayList<String>();

    private String guess;
    private String answer;
    private int lives = 5;

    public WordGuessGame(){
        solutions.add("communication");
        solutions.add("science");
        solutions.add("programming");
        solutions.add("language");
        solutions.add("difficulty");
        solutions.add("artificial");
        solutions.add("intelligence");
        solutions.add("attempts");
        solutions.add("screenshot");
        solutions.add("baseball");
        solutions.add("windows");
        solutions.add("learning");
        solutions.add("electornics");
        solutions.add("beautiful");
        solutions.add("internet");
        solutions.add("database");
        solutions.add("organization");
        solutions.add("application");
        solutions.add("network");
        solutions.add("friendly");
        solutions.add("validation");
        solutions.add("attempts");
        solutions.add("statistics");
        solutions.add("physics");
        solutions.add("chemistry");
        solutions.add("engineering");
        solutions.add("school");
        solutions.add("industry");
        solutions.add("revolution");
        solutions.add("progress");
        solutions.add("characters");
        solutions.add("heavily");
        solutions.add("graphics");
        answer = generateSolution();
    }
    

    private String generateSolution(){
        Random r = new Random();
        int solution = r.nextInt(32);
        return solutions.get(solution);
    }

    public String getSolution(){
        return answer;
    }

    public void setGuess(String c){
        guess = c;
    }

    public String getGuess(){
        return guess;
    }

    public int getLives(){
        if(lives == 0){
            lives = 5;
        }
        return lives;
    }

}
