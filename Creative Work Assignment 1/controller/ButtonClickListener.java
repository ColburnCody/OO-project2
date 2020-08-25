package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.BattleSimulator;
import view.MenuScreen;

public class ButtonClickListener implements ActionListener{

    private BattleSimulator panel;

    public ButtonClickListener(BattleSimulator panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var button = e.getSource();
        String m = panel.getDisplay().getText() + "\n";
        if(button == panel.getExitButton()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else if(button == panel.getAttackButton()){
            
        }
    }
    
}