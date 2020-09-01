package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Triangle;

public class TriangleCanvas extends JPanel {

    private TriangleDrawingPanel panel;

    public TriangleCanvas(TriangleDrawingPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Triangle t1 = new Triangle();
        t1.setPos(0, 10, 10);
        t1.setPos(1, 100, 100);
        t1.setPos(2, 150, 100);
        t1.setColor(Color.yellow);
        t1.render(g2);
    }
    
}