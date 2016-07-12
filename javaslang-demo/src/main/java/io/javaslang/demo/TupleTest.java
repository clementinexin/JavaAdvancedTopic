package io.javaslang.demo;

import javaslang.Tuple;
import javaslang.Tuple2;

/**
 * Created by daijiajia on 16/7/11.
 */
public class TupleTest {
    public static void main(String[] args) {
        Tuple2<String, Integer> tuple2 = Tuple.of("javaslang", 8);
        System.out.println(tuple2._1);
        System.out.println(tuple2._2);

        Tuple2<String, Integer> tuple21 = tuple2.map(
                s -> s + " jdk8",
                i -> i / 2
        );
        System.out.println(tuple21);

        Tuple2<String, Integer> tuple22 = tuple2.map(
                (s, i) -> Tuple.of(s + " jdk8", i / 2)
        );
        System.out.println(tuple22);

        String out = tuple2.transform(
                (s, i) -> s + " jdk " + i
        );
        System.out.println(out);
    }
}
