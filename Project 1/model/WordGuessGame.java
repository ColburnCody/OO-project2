package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordGuessGame {

    public ArrayList<String> solutions = new ArrayList<String>(Arrays.asList("communication", "science", "programming"
        , "language", "difficulty", "artificial", "intelligence", "attempts", "screenshot", "baseball", "windows"
        , "learning", "electronics", "beautiful", "internet", "database", "organization", "application", "network"
        , "friendly", "validation", "attempts", "statistics", "physics", "chemistry", "engineering", "school", "industry"
        , "revolution", "progress", "characters", "heavily", "graphics"));

    private char guess;
    private String answer;
    private int lives;

    public WordGuessGame(){
        lives = 5;
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

    public void setGuess(char c){
        guess = c;
    }

    public char getGuess(){
        return guess;
    }

    public int getLives(){
        return lives;
    }

}
