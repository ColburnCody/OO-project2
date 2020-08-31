package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.BaseballGame;
import view.BaseballGamePanel;
import view.MenuScreen;

public class BaseballKeyListener implements ActionListener{

    private BaseballGamePanel panel;

    public BaseballKeyListener(BaseballGamePanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == panel.getPlayButton()){
            var baseball = new BaseballGame();
            panel.setBaseball(baseball);
            panel.setGameState(BaseballGamePanel.GameState.PLAYING);
            int[] keys = baseball.getKey();
            String keyString = "" + keys[0] + keys[1] + keys[2];
            panel.getGameKeyField().setText(keyString);
            panel.getGuessField().setText("");
            // enable digit buttons
            for (var b: panel.getDigitButtons()){
                b.setEnabled(true);
            }
            panel.getCanvas().repaint();
        } else if(button == panel.getExitButton()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        }

    }
    
}