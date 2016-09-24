package cn.sorato.homework1;

import java.util.stream.IntStream;

/**
 * Created by kongren on 2016/9/11.
 */
public class MulTable{
    int size;

    public MulTable(int size){
        this.size = size;
    }

    public void classicPrint(){
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= i; j++)
                System.out.print(String.format("%d * %d = %d\t", j, i, i * j));
            System.out.print("\n");
        }
    }

    /**
     * 妈妈我以后再也不装逼了
     */
    public void streamPrint(){
        System.out.print(
                IntStream.iterate(1, i->i + 1)
                        .limit(size)
                        .mapToObj(n->IntStream.iterate(1, i->i + 1)
                                .limit(n)
                                .mapToObj(e->String.format("%d * %d = %d", e, n, e * n))
                                .reduce((a, b)->a + "\t" + b)
                                .get()
                        )
                        .reduce((a, b)->a + "\n" + b)
                        .get()
        );
    }
}
