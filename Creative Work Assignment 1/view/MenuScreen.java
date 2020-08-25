package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ButtonClickListener;

import javax.swing.JButton;

public class MenuScreen {

    private JFrame window;

    private JButton warriorButton = new JButton("Play as a warrior");
    private JButton wizardButton = new JButton("Play as a wizard");
    private JButton rangerButton = new JButton("Play as a ranger");

    public MenuScreen(final JFrame window) {
        this.window = window;
        window.setTitle("Epid Dragon Battle Simulator");
    }

    public void init() {
        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setLayout(new GridLayout(1, 3));

        panel.add(warriorButton);
        panel.add(wizardButton);
        panel.add(rangerButton);
        cp.add(BorderLayout.CENTER, panel);

        ButtonClickListener buttonClickListener = new ButtonClickListener(this);
        warriorButton.addActionListener(buttonClickListener);
        wizardButton.addActionListener(buttonClickListener);
        rangerButton.addActionListener(buttonClickListener);
    } 

    public JButton getWarrior(){
        return warriorButton;
    }

    public JButton getWizard(){
        return wizardButton;
    }

    public JButton getRanger(){
        return rangerButton;
    }

	public JFrame getWindow() {
		return window;
	}
}