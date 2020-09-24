package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Suit;

public class MemoryCanvas extends JPanel {

    private MemoryPanel panel;
    MemoryPanel.GameState state;
    private ArrayList<Suit> deck;
    

    public MemoryCanvas(MemoryPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        state = panel.getGameState();
        if(state == MemoryPanel.GameState.PLAYING){
            for(var c: deck){
                c.render(g2);
            }

        }
    }
    
    public ArrayList<Suit> getDeck() {
        return deck;
    }
    
}
