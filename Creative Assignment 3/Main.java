import javax.swing.JFrame;

import view.GardenScreen;

public class Main{

    public static void main(String[] args){

        javax.swing.JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);

        var garden = new GardenScreen(window);
        garden.init();

        window.pack();
        window.setVisible(true);

    }
}