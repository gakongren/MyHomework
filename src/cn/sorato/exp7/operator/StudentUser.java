package cn.sorato.exp7.operator;

import cn.sorato.exp7.Permission;

/**
 * Created by kongren on 2016/11/21.
 */
public class StudentUser extends User{
    public StudentUser(){
        super();
        this.addPermission(Permission.SCORE_GET);
    }
}
