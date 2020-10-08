package controller;

import java.awt.event.KeyListener;
import java.util.Random;

import model.IShapeDraw;
import model.Obstacle;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameListener implements ActionListener, KeyListener {

    private GamePanel panel;

    private int x;
    private int y;
    private int w;
    private int h;
    private Random r;



    public static final int UNIT_MOVE = 5;

    public GameListener(GamePanel panel){
        this.panel = panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panel.getNewButton()){
            panel.getCanvas().getObstacles().clear(); 
            if(panel.getSecretButton().isSelected()){
                for(int i = 0; i < 30; i++){
                    r = new Random();
                    x = r.nextInt(500);
                    y = r.nextInt(500);
                    w = r.nextInt(30) + 10;
                    h = r.nextInt(30) + 10;
                    IShapeDraw obstacle = new Obstacle(x, y, h, w);
                    panel.getCanvas().getObstacles().add(obstacle);
                }
            }else{
                for(int i = 0; i < 15; i++){
                    r = new Random();
                    x = r.nextInt(500);
                    y = r.nextInt(500);
                    w = r.nextInt(30) + 10;
                    h = r.nextInt(30) + 10;
                    IShapeDraw obstacle = new Obstacle(x, y, h, w);
                    panel.getCanvas().getObstacles().add(obstacle);
                }
            }
            panel.getCanvas().repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        var key = e.getKeyCode();
        IShapeDraw p = panel.getCanvas().getPlayer();
        switch(key){
            case KeyEvent.VK_LEFT:
                p.translate(-UNIT_MOVE, 0);
                break;
            case KeyEvent.VK_RIGHT:
                p.translate(UNIT_MOVE, 0);
                break;
            case KeyEvent.VK_UP:
                p.translate(0, -UNIT_MOVE);
                break;
            case KeyEvent.VK_DOWN:
                p.translate(0, UNIT_MOVE);
        }
        panel.getCanvas().repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
    
}
