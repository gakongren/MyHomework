package cn.sorato.exp2;

import cn.sorato.exp2.Graphic.Graphic;
import cn.sorato.exp2.Graphic.Square;
import cn.sorato.exp2.Graphic.Triangle;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kongren on 2016/12/14.
 */
public class GraphicTest{
    Graphic q1, q2;

    @Before
    public void setUp() throws Exception{
        q1 = new Square(0.5, 3.5, false);
        q2 = new Triangle(1.5, 7.7, 5d, false);
    }

    @Test
    public void testGraphic(){
        //实验内容:
        q1.showOnConsole();
        q2.showOnConsole();
        q1.setHeight(1.5).setWidth(2.5).setIsFilled(true);
        q1.showOnConsole();
    }
}