package view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import model.IShapeDraw;
import model.Player;

public class GameCanvas extends JPanel {

    private GamePanel panel;
    private ArrayList<IShapeDraw> obstacles = new ArrayList<>();
    private Player player;

    public GameCanvas(GamePanel panel){
        this.panel = panel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Random r = new Random();
        int x = r.nextInt(20);
        int y = r.nextInt(20);
        player = new Player(x, y);
        player.render(g2);
        for(int i = 0; i < obstacles.size(); i++){
            obstacles.get(i).render(g2);
        }
    }
    
    public ArrayList<IShapeDraw> getObstacles() {
        return obstacles;
    }

    public Player getPlayer() {
        return player;
    }
}
