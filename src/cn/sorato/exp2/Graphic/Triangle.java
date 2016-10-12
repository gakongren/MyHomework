package cn.sorato.exp2.Graphic;

/**
 * Created by kongren on 2016/10/10.
 */
public class Triangle extends Graphic{
    public Triangle(){
        super();
    }

    public Triangle(double h, double w, boolean b){
        super(h, w, b);
    }

    @Override
    public void showOnConsole(){
        System.out.println((isFilled ? "实心" : "空心") + "三角形 长:" + width + " 高:" + height);
    }
}
