package cn.sorato.exp4.ducks;

/**
 * Created by kongren on 2016/10/24.
 */
public class SilenceDuck extends Duck implements IFlyable{
    @Override
    public void fly(){
        z += 1.5;
        System.out.println("SilenceDuck flies to " + z);
    }

    @Override
    public void display(){
        System.out.println("SilenceDuck");
    }
}
