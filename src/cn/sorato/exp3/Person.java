package cn.sorato.exp3;

public class Person{
    public Gender gender;
    public String name;
    public int age;

    public enum Gender{
        male, female
    }

    Person(){
    }

    public Person(String name, int age, Gender sex){
        this();
        setData(name, age, sex);
    }

    public String toString(){
        return getData();
    }

    public Person setData(String name, int age, Gender sex){
        this.name = name;
        this.gender = sex;
        this.age = age;
        return this;
    }

    public String getData(){
        return "{Name:" + name + ""
                + ",Gender:" + gender.name()
                + ",age:" + age
                + "}";
    }

}
