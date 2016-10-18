package cn.sorato.exp3;

public class Exp3{
    /**
     * 第三次实验
     */
    public static void test(){
        Person john = new Person("John", 5, Person.Gender.male);
        Student alex = new Student();
        alex.setData("alex", 15, Person.Gender.male, 0x0099FF, 9);
        Car c = new Car();
        Motorbike m = new Motorbike();

        System.out.println(john);
        System.out.println(alex);
        System.out.println(c.wheelInfo());
        System.out.println(m.wheelInfo());

        Rodent[] r = {new Hamster(), new Mouse(), new Hamster()};
        for(Rodent e : r){
            e.eatNuts();
        }
    }

}
