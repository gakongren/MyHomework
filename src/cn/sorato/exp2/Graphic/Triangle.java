package cn.sorato.exp2.Graphic;

/**
 * Created by kongren on 2016/10/10.
 */
public class Triangle extends Graphic{
    public double topPointX = 0;

    public Triangle(double h, double w, double topPointX, boolean b){
        super(h, w, b);
        this.topPointX = topPointX;
    }

    @Override
    public void showOnConsole(){
        System.out.println((isFilled ? "实心" : "空心") + "三角形 长:" + width + " 高:" + height + " 顶部点横坐标:" + topPointX);
    }
}
