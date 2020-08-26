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
                panel.getDragon().combat(panel.getHero().getAttack());
                panel.getHero().combat(panel.getDragon().getAttack());
                panel.getDisplay().setText(m + "The dragon has attacked you! You have " + panel.getHero().getHealth() + " health left!\nYou attacked the dragon! He has " + panel.getDragon().getHealth() + " health left!");
            if(panel.getDragon().getHealth() <= 0){
                panel.getDisplay().setText(m + "The dragon has fled! You were so brave and cool and the best at pushing buttons!");
                panel.getAttackButton().setEnabled(false);
            } else if(panel.getHero().getHealth() <= 0){
                panel.getDisplay().setText(m + "You decided that the dragon seemed happy with his gold and bravely ran away!\nWhat a hero!");
                panel.getAttackButton().setEnabled(false);
            }
        }
    }
    
}