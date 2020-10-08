package view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Goal;
import model.IShapeDraw;
import model.Player;


public class GameCanvas extends JPanel {

    private GamePanel panel;
    private ArrayList<IShapeDraw> obstacles = new ArrayList<>();
    private Player player;
    private Goal goal;

    public GameCanvas(GamePanel panel){
        this.panel = panel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
            player = new Player(20, 20);
            goal = new Goal(450, 450);
            player.render(g2);
            goal.render(g2);
            for(var o: obstacles){
                o.render(g2);
        }
    }
    
    public ArrayList<IShapeDraw> getObstacles() {
        return obstacles;
    }

    public Player getPlayer() {
        return player;
    }

    public Goal getGoal() {
        return goal;
    }
}
