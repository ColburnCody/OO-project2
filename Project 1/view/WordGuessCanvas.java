package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WordGuessCanvas extends JPanel {
    
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private WordGuessPanel panel;

    public WordGuessCanvas(final WordGuessPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }

}
