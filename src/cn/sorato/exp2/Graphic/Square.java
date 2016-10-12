package cn.sorato.exp2.Graphic;

/**
 * Created by kongren on 2016/10/10.
 */
public class Square extends Graphic{
    public Square(double h, double w, boolean b){
        super(h, w, b);
    }

    public Square(){
        super();
    }

    @Override
    public void showOnConsole(){
        System.out.println((isFilled ? "实心" : "空心") + "长方形 长:" + width + " 高:" + height);
    }
}
