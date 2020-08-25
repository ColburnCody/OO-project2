package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.BattleSimulator;
import view.MenuScreen;

public class ButtonClickListener implements ActionListener {

    private MenuScreen panel;

    public ButtonClickListener(MenuScreen panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var button = e.getSource();
        if(button == panel.getWarrior()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var battle = new BattleSimulator(window, 0);
            battle.init();
            window.pack();
            window.revalidate();
        }
    }
    
}