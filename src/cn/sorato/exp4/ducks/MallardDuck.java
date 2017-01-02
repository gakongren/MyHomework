package cn.sorato.exp4.ducks;


import java.util.Random;

/**
 * Created by kongren on 2016/10/24.
 */
public class MallardDuck extends Duck implements IQuackable, IFlyable{
    private static Random rnd = new Random();

    @Override
    public void fly(){
        z += 1.5 * rnd.nextDouble();
        System.out.println("MallardDuck flies to " + z);
    }

    @Override
    public void quack(){
        System.out.print("GA");
        if(rnd.nextBoolean()){
            tk.beep();
            System.out.println("\tGA");
        }else{
            System.out.println();
        }
    }

    @Override
    public void display(){
        System.out.println("MallardDuck");
    }
}
