package main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by XRXY on 16-9-26.
 */
public class Main {
    static MathContext mc = new MathContext(128, RoundingMode.HALF_UP);

    private static class FSupplier implements Supplier<BigInteger> {
        BigInteger a = new BigInteger("0"), b = new BigInteger("1");

        @Override
        public BigInteger get() {
            BigInteger l = a.add(b);
            a = b;
            b = l;
            return l;
        }
    }

    public static void main(String[] args) {
        Stream<BigInteger> fibonacci = Stream.generate(new FSupplier());
        Stream<BigDecimal> goldenDivision = Stream.generate(new Supplier<BigDecimal>() {
            FSupplier fs = new FSupplier();

            public BigDecimal get() {
                fs.get();
                return new BigDecimal(fs.a).divide(new BigDecimal(fs.b), mc).stripTrailingZeros();
            }
        });
//        goldenDivision.limit(50)
//                .peek(System.out::println)
//                .map(e -> e.subtract(
//                        new BigDecimal(Math.sqrt(5), mc)
//                                .subtract(BigDecimal.ONE)
//                                .divide(BigDecimal.valueOf(2), mc)))
//                .peek(System.out::println)
//                .forEach(e->System.out.print('\n'));
        fibonacci.skip(50).limit(50).forEach(System.out::println);

    }
}
