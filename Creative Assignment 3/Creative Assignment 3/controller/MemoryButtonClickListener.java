package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Suit;
import view.MemoryPanel;

public class MemoryButtonClickListener implements ActionListener, MouseListener {

    private MemoryPanel panel;

    private ArrayList<Suit> deck;
    private Random r;

    public MemoryButtonClickListener(MemoryPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == panel.getNewButton()){
            if(!panel.getEasyButton().isSelected() && !panel.getMediumButton().isSelected() && !panel.getHardButton().isSelected()){
                JOptionPane.showMessageDialog(null, "Please select a difficulty", "Error", JOptionPane.CANCEL_OPTION);
            }else{
                if(panel.getEasyButton().isSelected()){
                    r = new Random();
                    for(int i = 0; i < 2; i++){
                        int s = r.nextInt(4);
                        int c = r.nextInt(2);
                    }
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    
}
