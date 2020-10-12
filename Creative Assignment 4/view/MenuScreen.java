package view;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


public class MenuScreen {

    private JFrame window;

    JLabel label = new JLabel("A tiny dragon has appeared before you!");

    private static JRadioButton warriorButton = new JRadioButton("Play a warrior");
    private static JRadioButton wizardButton = new JRadioButton("Play a wizard");
    private static JRadioButton rangerButton = new JRadioButton("Play a ranger");
    private static JCheckBox secretButton = new JCheckBox("This button is a secret");
    private JButton runButton = new JButton("Bravely retreat");
    private JButton fightButton = new JButton("Beat up a tiny dragon");

    public MenuScreen(JFrame window) {
        this.window = window;
        window.setTitle("Epic Dragon Battle Simulator V2.0");
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.add(label);
        cp.add(BorderLayout.NORTH, northPanel);

        JPanel centerPanel = new JPanel();
        JPanel radioPanel = new JPanel();
        ButtonGroup classGroup = new ButtonGroup();
        radioPanel.add(warriorButton);
        classGroup.add(warriorButton);
        radioPanel.add(wizardButton);
        classGroup.add(wizardButton);
        radioPanel.add(rangerButton);
        classGroup.add(rangerButton);
        TitledBorder title = BorderFactory.createTitledBorder("Choose your fighter!");
        radioPanel.setBorder(title);
        centerPanel.add(BorderLayout.CENTER, radioPanel);
        cp.add(BorderLayout.CENTER, centerPanel);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(fightButton);
        buttonPanel.add(runButton);
        buttonPanel.add(secretButton);
        southPanel.add(buttonPanel);
        southPanel.add(secretButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        fightButton.addActionListener(event -> {
            if (warriorButton.isSelected() || wizardButton.isSelected() || rangerButton.isSelected()) {
                window.getContentPane().removeAll();
                var battle = new BattleSimulator(window);
                battle.init();
                window.pack();
                window.revalidate();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a class to play!", "No class selected",
                        JOptionPane.CANCEL_OPTION);
            }
        });

        runButton.addActionListener(event -> {
            JOptionPane.showMessageDialog(null, "You bravely ran away!", "So brave", JOptionPane.CANCEL_OPTION);
        });

    }

    public static String getHero() {
        String hero = "";
        if (warriorButton.isSelected()) {
            hero = "warrior";
        } else if (wizardButton.isSelected()) {
            hero = "wizard";
        } else if (rangerButton.isSelected()) {
            hero = "ranger";
        }
        return hero;
    }

    public static JCheckBox getSecretButton() {
        return secretButton;
    }
}
