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

import model.Dragon;
import model.Warrior;

public class BattleSimulator {

    private JFrame window;

    private JTextArea display = new JTextArea();

    private JButton attackButton = new JButton("Attack!");
    private JButton defendButton = new JButton("Block!");
    private JButton exitButton = new JButton("Exit");

    private Dragon dragon = new Dragon();

    public BattleSimulator(JFrame window, int x){
        this.window = window;
        window.setTitle("Defeat the dragon!");
        if(x == 0){
            Warrior character = new Warrior();
        }
    }

    public void init(){
        Container cp = window.getContentPane();
        var scrollPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500,500));
        cp.add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.setLayout(new GridLayout(3, 1));
    }
    
}