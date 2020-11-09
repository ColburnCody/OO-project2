package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.KeyController;
import controller.TimerListener;
import model.EnemyComposite;
import model.Shooter;
import model.ShooterElement;
import model.Observer.ShooterObserver;

public class GameBoard {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    public static final int FPS = 20;
    public static final int DELAY = 1000 / FPS;
    
    private JFrame window;
    private MyCanvas canvas;
    private Shooter shooter;
    private EnemyComposite enemyComposite;
    private Timer timer;
    private TimerListener timerListener;
    private JLabel scoreDisplay = new JLabel();
    private int score = 0;
    private boolean gameOver = true;

    public GameBoard(JFrame window){
        this.window = window;
    }

    public void init(){

        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        scoreDisplay.setText("");
        JLabel label = new JLabel("Score: ");
        northPanel.add(label);
        scoreDisplay.setText("" + score);
        northPanel.add(scoreDisplay);
        JButton clearButton = new JButton("Clear score");
        northPanel.add(clearButton);
        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new MyCanvas(this, WIDTH, HEIGHT);
        cp.add(BorderLayout.CENTER, canvas);
        canvas.addKeyListener(new KeyController(this));
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);


        JButton startButton = new JButton("Start");
        JButton quitButton = new JButton("Quit");
        startButton.setFocusable(false);
        quitButton.setFocusable(false);
        clearButton.setFocusable(false);

        JPanel southPanel = new JPanel();
        southPanel.add(startButton);
        southPanel.add(quitButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        canvas.getGameElements().add(new TextDraw("Click <Start> to Play", 100, 100, Color.yellow, 30));

        timerListener = new TimerListener(this);
        timer = new Timer(DELAY, timerListener);

        startButton.addActionListener(event -> {
            setGameOver(false);
            shooter = new Shooter(GameBoard.WIDTH / 2, GameBoard.HEIGHT - ShooterElement.SIZE);
            ShooterObserver observer = new ShooterObserver(this);
            shooter.addShooterListener(observer);
            enemyComposite = new EnemyComposite();
            canvas.getGameElements().clear();
            canvas.getGameElements().add(shooter);
            canvas.getGameElements().add(enemyComposite);
            score = 0;
            scoreDisplay.setText("" + score);
            timer.start();
        });

        clearButton.addActionListener(event -> {
            score = 0;
            scoreDisplay.setText("" + score);
        });

        quitButton.addActionListener(event -> System.exit(0));

    }

    public JFrame getWindow() {
        return window;
    }

    public EnemyComposite getEnemyComposite() {
        return enemyComposite;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public MyCanvas getCanvas() {
        return canvas;
    }

    public Timer getTimer() {
        return timer;
    }

    public TimerListener getTimerListener() {
        return timerListener;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public JLabel getScoreDisplay() {
        return scoreDisplay;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    

}
