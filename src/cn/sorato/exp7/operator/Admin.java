package cn.sorato.exp7.operator;

import cn.sorato.exp7.Permission;

/**
 * Created by kongren on 2016/11/21.
 */
public class Admin extends User{
    public Admin(){
        super();
        this.addPermission(Permission.ADMIN);
    }
}
