package cn.sorato.exp2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by kongren on 2016/10/10.
 */
public class GuessGame{
    private int value;

    public GuessGame(){
        this(256);
    }

    public GuessGame(int bound){
        value = new Random().nextInt(bound);
        System.out.println("猜数范围:0至" + bound);
    }

    public boolean guess(int i){
        if(i == value)
            return true;
        else if(i > value)
            System.out.println("大了");
        else
            System.out.println("小了");
        return false;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        boolean b;
        do{
            b = guess(sc.nextInt());
        }while(!b);
        System.out.println("踩中,结束");
        sc.close();
    }
}
