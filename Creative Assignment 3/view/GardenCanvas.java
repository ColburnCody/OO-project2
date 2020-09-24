package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GardenCanvas extends JPanel {
    private GardenScreen panel;

    public GardenCanvas(GardenScreen panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.cyan);      
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.green);
        g2.fillOval(70, 300, 1000, 1000);
    }
    
}
