package cn.sorato.exp7.operator;

import cn.sorato.exp7.Permission;

/**
 * Created by kongren on 2016/11/21.
 */
public class TeacherUser extends User{
    public TeacherUser(){
        super();
        addPermission(Permission.SCORE_GET|Permission.SCORE_ADD);
    }
}
