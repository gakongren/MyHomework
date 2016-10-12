package cn.sorato.exp2.Graphic;

/**
 * Created by kongren on 2016/10/10.
 */
public abstract class Graphic{
    double height, width;
    boolean isFilled;

    public Graphic(){
        this(0, 0, false);
    }

    public Graphic(double h, double w, boolean b){
        this.height = h;
        this.width = w;
        this.isFilled = b;
    }

    public Graphic setHeight(double h){
        this.height = h;
        return this;
    }

    public Graphic setWidth(double w){
        this.width = w;
        return this;
    }

    public Graphic setIsFilled(boolean b){
        this.isFilled = b;
        return this;
    }

    public abstract void showOnConsole();
}
