package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import model.idemo.IRender;

import java.awt.Rectangle;

import view.IDemoPanel;

public class IDemoEventListener implements MouseListener {

    private IDemoPanel panel;

    public IDemoEventListener(IDemoPanel panel){
        this.panel = panel;
    }


   @Override
    public void mousePressed(MouseEvent e) {
        ArrayList<IRender> pictures = panel.getCanvas().getPictures();
        for(int i = 0; i < pictures.size(); i++){
            Rectangle r = pictures.get(i).getBoundingBox();
            if(r.contains(e.getX(), e.getY())){
                System.out.println("Selected index = " + i);
                return;
            }
        }
        System.out.println("Not selected");
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

 

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {


    }
    
}
