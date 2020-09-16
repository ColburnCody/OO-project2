package model;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class ChoiceQuestion extends Question {

    private ArrayList<String> choices;

    public ChoiceQuestion(String text, String answer){
        super(text, answer);
        choices = new ArrayList<>();
    }

    public void addChoices(String c){
        choices.add(c);
    }

    @Override
    public void display(){
        super.display();
        int no = 1;
        for(var c: choices){
            System.out.println("\t" + no + ". " + c);
            ++no;
        }
    }

    @Override
    public void render(Graphics2D g2){
        super.render(g2);
        g2.setColor(Color.white);
        g2.setFont(new Font("Courier", Font.BOLD, 12));
        int no = 1;
        for(var c: choices){
            g2.drawString(no + ". " + c, 80, no * 50 + 100);
            no++;
        }
    }
    
}
