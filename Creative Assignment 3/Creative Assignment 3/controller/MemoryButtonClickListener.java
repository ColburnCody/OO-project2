package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Suit;
import view.MemoryPanel;

public class MemoryButtonClickListener implements ActionListener, MouseListener {

    private MemoryPanel panel;

    private int s;
    private int c;
    private String val;
    private Color color;
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
                ArrayList<Suit> deck = panel.getCanvas().getDeck();
                deck.clear();
                panel.setGameState(MemoryPanel.GameState.PLAYING);
                panel.getNewButton().setEnabled(false);
                if(panel.getEasyButton().isSelected()){
                    r = new Random();
                    for(int i = 0; i < 2; i++){
                        s = r.nextInt(4);
                        c = r.nextInt(2);
                        if(s == 0){
                            val = "A";
                        }else if(s == 1){
                            val = "K";
                        } else if(s == 2){
                            val = "Q";
                        } else{
                            val = "J";
                        }
                        if(c == 0){
                            color = Color.red;
                        }else{
                            color = Color.black;
                        }
                        deck.add(new Suit(10 + i, i + 10, 20, 60, val, color, Color.white));
                        }
                    }else if(panel.getMediumButton().isSelected()){
                        r = new Random();
                        for(int i = 0; i < 4; i++){
                            int s = r.nextInt(4);
                            int c = r.nextInt(2);
                            if(s == 0){
                                val = "A";
                            }else if(s == 1){
                                val = "K";
                            } else if(s == 2){
                                val = "Q";
                            } else{
                                val = "J";
                            }
                            if(c == 0){
                                color = Color.red;
                            }else{
                                color = Color.black;
                            }
                            deck.add(new Suit(i + 50, i + 50, 20, 60, val, color, Color.white));
                            }
                         } else if(panel.getHardButton().isSelected()){
                            r = new Random();
                            for(int i = 0; i < 8; i++){
                                int s = r.nextInt(4);
                                int c = r.nextInt(2);
                                if(s == 0){
                                    val = "A";
                                }else if(s == 1){
                                    val = "K";
                                } else if(s == 2){
                                    val = "Q";
                                } else{
                                    val = "J";
                                }
                                if(c == 0){
                                    color = Color.red;
                                }else{
                                    color = Color.black;
                                }
                                deck.add(new Suit(i + 50, i + 50, 20, 60, val, color, Color.white));
                            }
                        }
                }
                panel.getCanvas().repaint();
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
