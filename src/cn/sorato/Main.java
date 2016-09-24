package cn.sorato;

import cn.sorato.homework2.CaseCast;
import cn.sorato.homework3.ArraySort;
import cn.sorato.homework3.Point;

/**
 * Created by kongren on 2016/9/23.
 */
public class Main{
    public static void main(String[] args){
        //10
        ArraySort a = new ArraySort(new int[]{9, 7, 8, 6, 10, 12}).setOrder();
        System.out.println(a);
        //11
        Point p = new Point().move(10, 20);
        System.out.println(p);
        /*
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
