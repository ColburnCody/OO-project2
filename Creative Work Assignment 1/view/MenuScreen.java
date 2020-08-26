package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import javax.swing.JButton;

public class MenuScreen {

    private JFrame window;

    private JLabel label = new JLabel("A little tiny baby dragon appears! What will you do?!?");
    private JButton warriorButton = new JButton("Play as a warrior");
    private JButton wizardButton = new JButton("Play as a wizard");
    private JButton rangerButton = new JButton("Play as a ranger");
    private JButton cowardButton = new JButton("Leave the lil guy alone");

    public MenuScreen(final JFrame window) {
        this.window = window;
        window.setTitle("Epic Dragon Battle Simulator");
    }

    public void init() {
        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setLayout(new GridLayout(3, 3));
        cp.add(panel);

        JPanel row1 = new JPanel();
        row1.add(label);
        panel.add(BorderLayout.CENTER, row1);

        JPanel row2 = new JPanel();
        row2.add(warriorButton);
        row2.add(wizardButton);
        row2.add(rangerButton);
        panel.add(BorderLayout.CENTER, row2);

        JPanel row3 = new JPanel();
        row3.add(cowardButton);
        panel.add(BorderLayout.CENTER, row3);

        warriorButton.addActionListener(e -> {
            window.getContentPane().removeAll();
            var battle = new BattleSimulator(window, 0);
            battle.init();
            window.pack();
            window.revalidate();
        });

        wizardButton.addActionListener(e -> {
            window.getContentPane().removeAll();
            var battle = new BattleSimulator(window, 1);
            battle.init();
            window.pack();
            window.revalidate();
        });

        rangerButton.addActionListener(e -> {
            window.getContentPane().removeAll();
            var battle = new BattleSimulator(window, 2);
            battle.init();
            window.pack();
            window.revalidate();
        });

        cowardButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "You bravely ran away!", "Coward", JOptionPane.CANCEL_OPTION);
        });

    } 
}