package cn.sorato.exp6;

import java.io.Serializable;

/**
 * Created by kongren on 2016/11/9.
 */
public class MessageObj implements Serializable{
    public String username;
    public String msg;

    public MessageObj(String username, String msg){
        this.username = username;
        this.msg = msg;
    }

    @Override
    public String toString(){
        return "{\"username\"=\"" + username + "\";\"msg\"=\"" + msg + "\"}";
    }
}
