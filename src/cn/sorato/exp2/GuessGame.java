package cn.sorato.exp2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by kongren on 2016/10/10.
 */
public class GuessGame{
    private int value;
    public int max, min;

    public GuessGame(){
        this(0, 256);
    }

    public GuessGame(int leftBound, int rightBound){
        value = leftBound + new Random().nextInt(rightBound - leftBound);
        max = Math.max(leftBound, rightBound);
        min = Math.min(leftBound, rightBound);
        System.out.println("猜数范围:" + leftBound + "至" + rightBound);
    }

    public boolean guess(int i){
        if(i == value){
            System.out.println(i + ":正确");
            return true;
        }else if(i > value)
            System.out.println(i + ":大了");
        else
            System.out.println(i + ":小了");
        return false;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        boolean b;
        do{
            b = guess(sc.nextInt());
        }while(!b);
        sc.close();
    }
}
