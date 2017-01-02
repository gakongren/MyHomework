package cn.sorato.exp7.operator;

import cn.sorato.exp7.Permission;

/**
 * Created by kongren on 2016/11/21.
 */
public class ScoreManeger extends User{
    public ScoreManeger(){
        super();
        addPermission(Permission.SCORE_ALL);
    }
}
