package cn.sorato.exp4.needspeed;

/**
 * Created by kongren on 2016/10/24.
 */
public class GoodPolice extends Police{
    public GoodPolice(String name){
        super(name, new DealToLiLei.Nothing());
    }
}
