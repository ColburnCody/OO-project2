package model;

import java.util.Random;

public class WordGuessGame {

    private String[] solutions = {"communication", "science", "programming", "language", "difficulty", "artificial", "intelligence",
        "attempts", "screenshot", "baseball", "windows", "learning", "electronics", "beautiful", "internet", "database", "organization",
        "application", "network", "friendly", "validation", "attempts", "statistics", "physics", "chemistry", "engineering",
        "school", "industry", "revolution", "progress", "characters", "heavily", "graphics"};

    private char guess;
    private String answer;
    private int lives = 5;

    public WordGuessGame(){
        answer = generateSolution();
    }
    

    private String generateSolution(){
        Random r = new Random();
        int solution = r.nextInt(33) + 1;
        return solutions[solution];
    }

    public void setGuess(char c){
        guess = c;
    }

    public void checkGuess(){
        // TODO
    }
}
