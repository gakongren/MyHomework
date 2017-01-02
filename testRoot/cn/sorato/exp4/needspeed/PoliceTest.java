package cn.sorato.exp4.needspeed;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kongren on 2017/1/2.
 */
public class PoliceTest{
    Person lilei;
    Police p0,p1,p2;
    @Before
    public void setup(){
        lilei = new Person("李雷");
        p0=new GoodPolice("警察1");
        p1=new BadPolice("警察2");
        p2=new ElderPolice("年长的警察3");
    }

    @Test
    public void test(){
        System.out.println(lilei);
        System.out.println(p1);
        p0.deal(lilei);
        p1.deal(lilei);
        p2.deal(lilei);
    }

}