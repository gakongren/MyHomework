package cn.sorato.exp4.needspeed;

/**
 * Created by kongren on 2016/10/24.
 */
public abstract class DealToLiLei{
    public abstract void doSomeThing(Person from, Person to);

    public static class Nothing extends DealToLiLei{
        @Override
        public void doSomeThing(Person from, Person to){
            System.out.println();
        }
    }

    public static class Talk extends DealToLiLei{
        @Override
        public void doSomeThing(Person from, Person to){
            System.out.println(from.name + "和" + to.name + "谈笑风生\n\t" + to.name + "发现自己的手表忽然向前跳了1s");
        }
    }

    public static class Fine extends DealToLiLei{
        @Override
        public void doSomeThing(Person from, Person to){
            to.money -= 10;
            from.money += 10;
            System.out.println(to.name + "被" + from.name + "罚款,身上还剩" + to.money);
            System.out.println(from.name + "获得罚金,身上有" + from.money);
        }
    }
}
