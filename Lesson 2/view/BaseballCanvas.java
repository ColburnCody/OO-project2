package view;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class BaseballCanvas extends JPanel{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private BaseballGamePanel panel;

    public BaseballCanvas(BaseballGamePanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // add custom drawing
    }
    
}