import javax.swing.JFrame;

import view.MemoryPanel;

public class Main{
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);

        var memory = new MemoryPanel(window);
        memory.init();

        window.pack();
        window.setVisible(true);
    }
}