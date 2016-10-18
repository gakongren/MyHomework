package cn.sorato.exp3;

public class Student extends Person{
    int sID, classNo;

    public Student(){
    }

    public Student(String name, int age, Gender sex, int sID, int classNo){
        super();
        this.setData(name, age, sex, sID, classNo);
    }

    public Student setData(String name, int age, Gender sex, int sID, int classNo){
        super.setData(name, age, sex);
        this.classNo = classNo;
        this.sID = sID;
        return this;
    }

    public String getData(){
        return "{Name:" + name + ""
                + ",Gender:" + gender.name()
                + ",age:" + age
                + ",sID:" + sID
                + ",classNo:" + classNo
                + "}";
    }
}
