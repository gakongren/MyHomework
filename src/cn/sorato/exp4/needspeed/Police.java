package cn.sorato.exp4.needspeed;

/**
 * Created by kongren on 2016/10/24.
 */
public abstract class Police extends Person{
    private DealToLiLei deals;

    Police(String name, DealToLiLei d){
        super(name);
        deals = d;
    }

    public void deal(Person to){
        deals.doSomeThing(this, to);
    }
}
