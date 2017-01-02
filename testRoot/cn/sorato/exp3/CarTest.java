package cn.sorato.exp3;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by kongren on 2017/1/2.
 */
public class CarTest{
    Car car;
    Motorbike bike;

    @Before
    public void setUp() throws Exception{
        car = new Car();
        bike = new Motorbike();
    }

    @Test
    public void test(){
        System.out.println(car.wheelInfo());
        System.out.println(bike.wheelInfo());
    }

}