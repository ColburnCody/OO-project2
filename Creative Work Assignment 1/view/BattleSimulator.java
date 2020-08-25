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
import model.Warrior;

public class BattleSimulator {

    private JFrame window;

    private JTextArea display = new JTextArea("A little tiny dragon appears! Can you beat him?");

    private JButton attackButton = new JButton("Attack!");
    private JButton defendButton = new JButton("Block!");
    private JButton exitButton = new JButton("Exit");

    private Dragon dragon = new Dragon();
    private Warrior hero;

    public BattleSimulator(JFrame window, int x){
        this.window = window;
        window.setTitle("Defeat the dragon!");
        if(x == 0){
            hero = new Warrior(50, 18, 20);
        } else if(x == 1){
            hero = new Warrior(40, 23, 15);
        } else if(x == 2){
            hero = new Warrior(45, 19, 18);
        }
    }

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
        row1.add(defendButton);
        southPanel.add(row1);

        JPanel row2 = new JPanel();
        row2.add(exitButton);
        southPanel.add(row2);

        ButtonClickListener buttonClickListener = new ButtonClickListener(this);
        exitButton.addActionListener(buttonClickListener);
        attackButton.addActionListener(buttonClickListener);
        defendButton.addActionListener(buttonClickListener);

    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getAttackButton(){
        return attackButton;
    }

    public JButton getDefendButton(){
        return defendButton;
    }

    public JFrame getWindow(){
        return window;
    }
    
    public JTextArea getDisplay(){
        return display;
    }

    public Warrior getHero(){
        return hero;
    }

    public Dragon getDragon(){
        return dragon;
    }
}