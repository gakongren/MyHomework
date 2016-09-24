package cn.sorato.homework3;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by kongren on 2016/9/24.
 */
public class ArraySort{
    int[] sim;

    public ArraySort(int[] sim){
        this.sim = sim;
    }

    public ArraySort setOrder(){
        this.sim = IntStream.of(sim).sorted().toArray();
        return this;
    }

    @Override
    public String toString(){
        Optional<String> op = IntStream.of(sim).mapToObj(String::valueOf).reduce((s1, s2)->s1.concat(",").concat(s2));
        return "[".concat(op.isPresent() ? op.get() : "").concat("]");
    }
}
