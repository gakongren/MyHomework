package cn.sorato.exp7;

import cn.sorato.exp7.info.Student;
import cn.sorato.exp7.operator.User;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by kongren on 2016/11/15.
 */
public class SysScore{
    ArrayList<Student> students;
    private static SysScore instance;

    public static SysScore get(){
        if(instance == null)
            instance = new SysScore();
        return instance;
    }

    public void auth(User.AuthInfo auth){

    }

    public Student[] getStudent(Predicate<Student> p){
        return students.stream().filter(p).toArray(Student[]::new);
    }
}
