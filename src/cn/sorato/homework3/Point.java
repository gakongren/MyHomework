package cn.sorato.homework3;

/**
 * Created by kongren on 2016/9/24.
 */
public class Point{
    int x, y;

    public Point(){
        this(0, 0);
    }

    public Point(int x, int y){
        move(x, y);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Point move(int x, int y){
        setX(x);
        setY(y);
        return this;
    }

    @Override
    public String toString(){
        return "point(" + x + "," + y + ")";
    }
}
