package cn.sorato.exp4.needspeed;

/**
 * Created by kongren on 2016/10/24.
 */
public class ElderPolice extends Police{
    public ElderPolice(String name){
        super(name,new DealToLiLei.Talk());
    }
}
