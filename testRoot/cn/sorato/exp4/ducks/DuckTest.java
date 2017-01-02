package cn.sorato.exp4.ducks;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by kongren on 2017/1/2.
 */
public class DuckTest{
    Duck[] d;

    @Before
    public void setUp() throws Exception{
        d = new Duck[]{new MallardDuck(), new RedHeadDuck(), new RubberDuck(),
                new WoodDuck(), new DuduDuck(), new SilenceDuck()};
    }

    @Test
    public void test(){
        for(Duck duck : d){
            duck.display();
            duck.swim();
            if(duck instanceof IFlyable)
                ((IFlyable) duck).fly();
            else
                System.out.println(duck + "它飞不起来");     //局座:他飞不起来
            if(duck instanceof IQuackable)
                ((IQuackable) duck).quack();
            else
                System.out.println(duck + "浮不起来");      //@爽代田浮不起来
        }
    }

}