package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MemoryCanvas extends JPanel {
    private MemoryPanel panel;

    public MemoryCanvas(MemoryPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }
    
}
