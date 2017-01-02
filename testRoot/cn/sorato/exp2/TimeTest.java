package cn.sorato.exp2;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by kongren on 2016/12/14.
 */
public class TimeTest{
    Time t;
    @Before
    public void setUp() throws Exception{
        t = new Time(1, 1, 119);
    }

    @Test
    public void testTime(){
        //实验内容:
        System.out.println(t);
        t.addHour(5);
        t.addSecond(1);
        System.out.println(t);
        t.addSecond(59);
        System.out.println(t);
        try{
            Method m = Time.class.getDeclaredMethod("plusOneSec");
            m.setAccessible(true);
            m.invoke(t);
        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        System.out.println(t);
    }

}