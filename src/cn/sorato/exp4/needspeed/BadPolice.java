package cn.sorato.exp4.needspeed;

/**
 * Created by kongren on 2016/10/24.
 */
public class BadPolice extends Police{
    public BadPolice(String name){
        super(name, new DealToLiLei.Fine());
    }
}
