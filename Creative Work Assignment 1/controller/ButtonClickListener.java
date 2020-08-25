package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.BattleSimulator;
import view.MenuScreen;

public class ButtonClickListener implements ActionListener{

    private BattleSimulator panel;
    private int heroHealth;
    private int heroAttack;
    private int dragonHealth;
    private int dragonAttack;

    public ButtonClickListener(BattleSimulator panel){
        this.panel = panel;
        heroHealth = panel.getHero().getHealth();
        heroAttack = panel.getHero().getAttack();
        dragonHealth = panel.getDragon().getHealth();
        dragonAttack = panel.getDragon().getAttack();

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
            if(dragonHealth > 0 && heroHealth > 0){
                dragonHealth -= heroAttack;
                heroHealth -= dragonAttack;
                panel.getDisplay().setText(m + "You attack the dragon! He has " + dragonHealth + " health left!\n" +  "The dragon attacks you! You have " + heroHealth + " health left!\n");
            }else if(dragonHealth <= 0){
                panel.getDisplay().setText(m + "The dragon got scared and ran away! You're the best at pushing buttons!\n");
            }else if(heroHealth <= 0){
                panel.getDisplay().setText(m + "You decided to bravely run away from this little tiny baby dragon!\n");
            }
        }
    }
    
}