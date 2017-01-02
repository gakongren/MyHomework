package cn.sorato.exp3;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by kongren on 2017/1/2.
 */
public class RodentTest{
    Rodent[] r;

    @Before
    public void setUp() throws Exception{
        r = new Rodent[]{new Hamster(), new Mouse(), new Gerbile()};
    }

    @Test
    public void test(){
        for(Rodent e : r){
            e.eatNuts();
        }
    }

}