package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.BattleSimulator;
import view.MenuScreen;

public class BattleActionListener implements ActionListener, MouseListener{

    private BattleSimulator panel;


    public BattleActionListener(BattleSimulator panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == panel.getFightButton()){
            if(panel.getDragon().getHealth() <= 0 || panel.getHero().getHealth() <= 0){
                panel.getDragon().setHealth();
                panel.getHero().setHealth();
            }
            panel.getFightButton().setEnabled(false);
            panel.getRewardButton().setEnabled(false);
            panel.setGameState(BattleSimulator.GameState.PLAYING);
            panel.getCanvas().repaint();
            panel.getDragonHealth().setText(""+panel.getDragon().getHealth());
            panel.getHeroHealth().setText(""+panel.getHero().getHealth());
        } else if(button == panel.getExitButton()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else if(button == panel.getRewardButton()){
            Random r = new Random();
            int reward = r.nextInt(100);
            JOptionPane.showMessageDialog(null, "You stole " + reward + " gold from that tiny baby dragon!", "You're the best at clicking", JOptionPane.CANCEL_OPTION);
            panel.getRewardButton().setEnabled(false);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(panel.getGameState() == BattleSimulator.GameState.PLAYING){
            panel.getDragon().combat(panel.getHero().getAttack());
            panel.getHero().combat(panel.getDragon().getAttack());
            panel.getDragonHealth().setText(""+panel.getDragon().getHealth());
            panel.getHeroHealth().setText(""+panel.getHero().getHealth());
            if(panel.getDragon().getHealth() <= 0){
                panel.getDragonHealth().setText("0");
                panel.setGameState(BattleSimulator.GameState.GAMEOVER);
                panel.getFightButton().setEnabled(true);
                panel.getRewardButton().setEnabled(true);
                panel.getCanvas().repaint();
            }else if(panel.getHero().getHealth() <= 0){
                panel.getHeroHealth().setText("0");
                panel.setGameState(BattleSimulator.GameState.GAMEOVER);
                panel.getFightButton().setEnabled(true);
                panel.getCanvas().repaint();
            }
        }
            
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

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }



    
}
