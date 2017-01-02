package cn.sorato.exp3;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by kongren on 2017/1/2.
 */
public class PersonTest{
    private Person john, alex;
    @Before
    public void setUp() throws Exception{
        john = new Person("John", 5, Person.Gender.male);
        alex = new Student().setData("alex", 15, Person.Gender.male, 0x0099FF, 9);
    }

    @Test
    public void test(){
        System.out.println(john);
        System.out.println(alex);
    }

}