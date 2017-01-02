package cn.sorato.exp4.ducks;

/**
 * Created by kongren on 2016/10/24.
 */
public abstract class Duck{
    double z = 0;

    public abstract void display();

    public void swim(){
        String s = getClass().getName();
        System.out.println(s.substring(s.lastIndexOf(".") + 1) + " swims.");
    }
}
