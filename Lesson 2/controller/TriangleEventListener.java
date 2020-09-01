package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JFrame;

import view.MenuScreen;
import view.TriangleDrawingPanel;

public class TriangleEventListener implements ActionListener {

    private TriangleDrawingPanel panel;

    private Color color = Color.white;

    public TriangleEventListener(TriangleDrawingPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == panel.getExitButton()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else if(source == panel.getClearButton()){

        } else if(source == panel.getRedButton()){
            color = Color.red;

        } else if(source == panel.getYellowButton()){
            color = Color.yellow;

        }else if(source == panel.getBlueButton()){
            color = Color.blue;

        }
    }
    
}