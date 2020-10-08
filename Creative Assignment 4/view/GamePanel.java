package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameListener;

public class GamePanel {

    private JFrame window;


    private GameCanvas canvas;
    private JButton newButton = new JButton("New Game");
    private JCheckBox secretButton = new JCheckBox("Secret mode");

    public GamePanel(JFrame window) {
        this.window = window;
    }

    public void init() {

        Container cp = window.getContentPane();

        canvas = new GameCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(newButton);
        southPanel.add(secretButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        GameListener l = new GameListener(this);
        newButton.addActionListener(l);
        secretButton.addActionListener(l);
        canvas.addKeyListener(l);
        canvas.setFocusable(true);

        newButton.setFocusable(false);
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public JCheckBox getSecretButton() {
        return secretButton;
    }


}