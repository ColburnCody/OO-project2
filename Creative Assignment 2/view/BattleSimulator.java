package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.print.StreamPrintServiceFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BattleActionListener;
import model.Dragon;
import model.Hero;

public class BattleSimulator {

    private BattleCanvas canvas;

    public enum GameState{
        READY, PLAYING, GAMEOVER;
    }

    private GameState gameState = GameState.READY;

    private JFrame window;
    private Hero hero = new Hero();
    private Dragon dragon = new Dragon();
    private JTextField dragonHealth = new JTextField();
    private JTextField heroHealth = new JTextField();

    private JButton exitButton = new JButton("Exit");
    private JButton rewardButton = new JButton("Reward");
    private JButton fightButton = new JButton("Fight!");

    public BattleSimulator(JFrame window){
        this.window = window;
        window.setTitle("Defeat the dragon!");
    }

    public void init(){
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(new JLabel("Your health: "));
        northPanel.add(new JLabel("Dragon health: "));
        northPanel.add(heroHealth);
        heroHealth.setEditable(false);
        northPanel.add(dragonHealth);
        dragonHealth.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new BattleCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 3));
        southPanel.add(fightButton);
        southPanel.add(rewardButton);
        rewardButton.setEnabled(false);
        southPanel.add(exitButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        BattleActionListener listener = new BattleActionListener(this);
        canvas.addMouseListener(listener);
        rewardButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        fightButton.addActionListener(listener);

    }

    public Hero getHero(){
        return hero;
    }

    public Dragon getDragon(){
        return dragon;
    }

    public BattleCanvas getCanvas(){
        return canvas;
    }

    public JButton getRewardButton(){
        return rewardButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getFightButton(){
        return fightButton;
    }

    public GameState getGameState(){
        return gameState;
    }
    
}
