package cn.sorato.exp4.ducks;

/**
 * Created by kongren on 2016/10/24.
 */
public class RedHeadDuck extends Duck implements IFlyable, IQuackable{
    @Override
    public void fly(){
        z += 1.5;
        System.out.println("RedHeadDuck flies to " + z);
    }

    @Override
    public void quack(){
        tk.beep();
        System.out.println("AGAGAGA");
    }

    @Override
    public void display(){
        System.out.println("RedHeadDuck");
    }
}
