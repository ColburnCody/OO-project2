package model;

public abstract class Shape implements IShapeDraw  {

    private int x;
    private int y;

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void translate(int dx, int dy){
        x += dx;
        y += dy;
    }    

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}
