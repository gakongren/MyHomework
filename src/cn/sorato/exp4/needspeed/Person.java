package cn.sorato.exp4.needspeed;

/**
 * Created by kongren on 2016/10/24.
 */
public class Person{
    float money = 90F;
    final String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name + ":$" + money;
    }
}
