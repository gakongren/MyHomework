package cn.sorato.exp4.ducks;

/**
 * Created by kongren on 2016/10/24.
 */
public class DuduDuck extends Duck implements IQuackable{
    @Override
    public void display(){
        System.out.println("DuduDuck");
    }

    @Override
    public void quack(){
        tk.beep();
        System.out.println("UDUDUDU");
    }
}
