package test;

import java.util.ArrayList;

import java.awt.Color;

import model.Circle;
import model.Rectangle;
import model.Shape;

public class ShapesTest {

    public static void main(String[] args){

        Circle c1 = new Circle(1, 1, Color.white, 2);
        assert isEqual(c1.getX(), c1.getY());
        assert isEqual(c1.getArea(), (float)(2*2*Math.PI));

        Rectangle r1 = new Rectangle(10, 12.5f, Color.red, 5, 7);
        assert isEqual(r1.getArea(), (float)(5*7));
        assert isEqual(12.5f, r1.getY());

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(0, 0, Color.white, 1));
        shapes.add(new Circle(1, 1, Color.white, 2));
        shapes.add(new Rectangle(10, 10, Color.yellow, 5, 5));

        for(var s: shapes){
            System.out.println(s);
        }
    }

    public static boolean isEqual(float x, float y){
        final float SMALL = 0.00000001f;
        // |x - y| < SMALL_NUMBER
        if(Math.abs(x - y) < SMALL){
            return true;
        } else{
            return false;
        }
    }
    
}
