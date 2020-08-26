package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ButtonClickListener;
import model.Dragon;
import model.Hero;

public class BattleSimulator {

    private JFrame window;

    private Dragon dragon = new Dragon();

    private JTextArea display = new JTextArea("You decided to fight the little tiny baby dragon! Can you beat him and steal his gold???");

    private JButton attackButton = new JButton("Attack!");
    private JButton exitButton = new JButton("Exit");
    public int heroType;


    public BattleSimulator(JFrame window, int x){
        this.window = window;
        window.setTitle("Defeat the dragon!");
        heroType = x;
    }

    private Hero hero = new Hero(heroType);



    public void init(){

        Container cp = window.getContentPane();
        var scrollPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500,500));
        cp.add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.setLayout(new GridLayout(2, 1));

        JPanel row1 = new JPanel();
        row1.add(attackButton);
        southPanel.add(row1);

        JPanel row2 = new JPanel();
        row2.add(exitButton);
        southPanel.add(row2);

        ButtonClickListener buttonClickListener = new ButtonClickListener(this);
        exitButton.addActionListener(buttonClickListener);
        attackButton.addActionListener(buttonClickListener);

    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getAttackButton(){
        return attackButton;
    }

    public JFrame getWindow(){
        return window;
    }
    
    public JTextArea getDisplay(){
        return display;
    }

    public Hero getHero(){
        return hero;
    }

    public Dragon getDragon(){
        return dragon;
    }
}