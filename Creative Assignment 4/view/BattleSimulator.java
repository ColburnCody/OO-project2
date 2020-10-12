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
import model.Ranger;
import model.Warrior;
import model.Wizard;

public class BattleSimulator {

    private BattleCanvas canvas;

    public enum GameState{
        READY, PLAYING, GAMEOVER;
    }

    private GameState gameState = GameState.READY;

    private JFrame window;
    private String setHero;
    private Hero hero;
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
        
        setHero = MenuScreen.getHero();
        if(setHero == "warrior"){
            hero = new Warrior(50, 25, 15);
        }else if(setHero == "wizard"){
            hero = new Wizard(40, 35);
        }else if(setHero == "ranger"){
            hero = new Ranger(45, 45);
        }

        JPanel southPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(fightButton);
        buttonPanel.add(rewardButton);
        rewardButton.setEnabled(false);
        buttonPanel.add(exitButton);
        southPanel.add(buttonPanel);
        cp.add(BorderLayout.SOUTH, buttonPanel);

        BattleActionListener listener = new BattleActionListener(this);
        canvas.addMouseListener(listener);
        rewardButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        fightButton.addActionListener(listener);

    }

    public JTextField getDragonHealth(){
        return dragonHealth;
    }

    public JTextField getHeroHealth(){
        return heroHealth;
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

    public void setGameState(GameState state){
        this.gameState = state;
    }
    
    public JFrame getWindow(){
        return window;
    }
}
