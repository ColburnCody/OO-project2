package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener

import view.GameBoard;

public class KeyController implements KeyListener {

    private GameBoard gameBoard;

    public KeyController(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch(keyCode){
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:
                break;
            case KeyEvent.VK_SPACE:
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
