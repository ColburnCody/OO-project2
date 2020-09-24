package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class GardenScreen {

    private JFrame window;

    private GardenCanvas canvas;

    private JButton clearButton = new JButton("Clear your garden");
    private JButton digButton = new JButton("Dig up a plant");

    private JRadioButton sunflowerButton = new JRadioButton("Sunflower");
    private JRadioButton roseButton = new JRadioButton("Rose");
    private JRadioButton daisyButton = new JRadioButton("Daisy");

    public GardenScreen(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();

        JPanel southPanel = new JPanel();
        JPanel radioPanel = new JPanel();
        ButtonGroup plantGroup = new ButtonGroup();
        radioPanel.add(sunflowerButton);
        plantGroup.add(sunflowerButton);
        radioPanel.add(roseButton);
        plantGroup.add(roseButton);
        radioPanel.add(daisyButton);
        plantGroup.add(daisyButton);
        TitledBorder title = BorderFactory.createTitledBorder("Choose what you want to plant");
        radioPanel.setBorder(title);
        southPanel.add(radioPanel);
        cp.add(BorderLayout.SOUTH, southPanel);

        JPanel northJPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(clearButton);
        buttonPanel.add(digButton);
        northJPanel.add(buttonPanel);
        cp.add(BorderLayout.NORTH, northJPanel);

        canvas = new GardenCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);
        
    }

    
}