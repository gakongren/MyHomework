package cn.sorato.exp7.operator;

import cn.sorato.exp7.Permission;
import cn.sorato.exp7.SysScore;
import cn.sorato.exp7.info.ScoreInfo;
import cn.sorato.exp7.info.Student;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by kongren on 2016/11/15.
 */
public abstract class User{
    AuthInfo auth;
    private int permissionCode;

    public class AuthInfo{
        String username,passwd;
        AuthInfo(String _name, String _passwd){
            username = _name;
            passwd = _passwd;
        }

        String getUsername(){
            return username;
        }

        String getPasswd() {
            return passwd;
        }
    }

    public User addPermission(int p){
        this.permissionCode |= p;
        return this;
    }

    public User removePermission(int p){
        this.permissionCode &= ~p;
        return this;
    }

    private boolean testPermission(int p){
        boolean b = (permissionCode & p) == 0;
        if(b)
            warn("没有权限:");
        return !b;
    }

    private Student[] searchStudent(Predicate<Student> p){
        if(!testPermission(Permission.SCORE_GET))
            return null;
        return SysScore.get().getStudent(p);
    }

    public Student[] searchStudentByName(String name){
        return searchStudent(p->p.getName().equals(name));
    }

    public Optional<ScoreInfo> searchScoreInfo(Student s, String courseName){
        if(!testPermission(Permission.SCORE_GET))
            return Optional.empty();
        return s.getScoreInfo(courseName);
    }

    public void setScoreInfo(Student s, String courseName, ScoreInfo info){
        boolean canAdd = testPermission(Permission.SCORE_ADD) && !s.hasScoreInfo(courseName),
                canSet = testPermission(Permission.SCORE_SET) && s.hasScoreInfo(courseName);
        if(canAdd || canSet)
            s.setScoreInfo(courseName, info);
    }

    private void warn(String s){
        //TODO:重写警告
    }

}
