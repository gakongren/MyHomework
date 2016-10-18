package cn.sorato.exp2;

import cn.sorato.exp2.Graphic.Graphic;
import cn.sorato.exp2.Graphic.Square;
import cn.sorato.exp2.Graphic.Triangle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kongren on 2016/10/18.
 */
public class Exp2{
    /**
     * 第二次实验
     */
    public static void test(){
        //实验内容:
        Time t = new Time(1, 2, 3);
        System.out.println(t);
        try{
            Method m = Time.class.getDeclaredMethod("plusOneSec");
            m.setAccessible(true);
            m.invoke(t);
        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }

        //实验内容:
        Graphic q1 = new Square().setHeight(0.5).setWidth(3.5).setIsFilled(true), q2 = new Triangle(1.5, 7.7, false);
        q1.showOnConsole();
        q2.showOnConsole();

        //实验内容:猜数游戏实验
        GuessGame game = new GuessGame(128);
        game.start();
    }
}
