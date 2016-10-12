package cn.sorato;

import cn.sorato.exp2.Graphic.Graphic;
import cn.sorato.exp2.Graphic.Square;
import cn.sorato.exp2.Graphic.Triangle;
import cn.sorato.exp2.GuessGame;
import cn.sorato.exp2.Time;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kongren on 2016/9/23.
 */
public class Main{
    public static void main(String[] args){
        Time t = new Time(1, 2, 3);
        System.out.println(t);
        try{
            Method m = Time.class.getDeclaredMethod("plusOneSec");
            m.setAccessible(true);
            m.invoke(t);
        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        Graphic q1 = new Square().setHeight(0.5).setWidth(3.5).setIsFilled(true), q2 = new Triangle(1.5, 7.7, false);
        q1.showOnConsole();
        q2.showOnConsole();

        GuessGame game = new GuessGame(128);
        game.start();
        /*
        //exp1
        Exp1.test();
        //10
        ArraySort a = new ArraySort(new int[]{9, 7, 8, 6, 10, 12}).setOrder();
        System.out.println(a);
        //11
        Point p = new Point().move(10, 20);
        System.out.println(p);
        String s = "abCDef123", s1 = "89Sz";
        CaseCast toLower = new CaseCast(CaseCast.Case.TO_LOWER), toUpper = new CaseCast(CaseCast.Case.TO_UPPER);
        System.out.println(toLower.process(s));
        System.out.println(toUpper.process(s1));
        System.out.println("输入乘法表大小");
        Scanner is = new Scanner(System.in);
        int n=is.nextInt();
        MulTable table=new MulTable(n);
        System.out.println("乘法表输出正常实现");
        table.classicPrint();
        System.out.println("乘法表输出装逼实现");
        table.streamPrint();
        */
    }
}
