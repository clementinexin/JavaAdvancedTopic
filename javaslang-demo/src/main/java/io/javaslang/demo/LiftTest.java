package io.javaslang.demo;

import javaslang.Function2;
import javaslang.control.Option;

/**
 * Created by daijiajia on 16/7/12.
 */
public class LiftTest {

    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;

        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        System.out.println(safeDivide.apply(1, 0));
//        System.out.println(safeDivide.apply(1, 0).get());
        System.out.println(safeDivide.apply(2, 1));
        System.out.println(safeDivide.apply(2, 1).get());
        LiftTest test = new LiftTest();
        Function2<Integer, Integer, Option<Integer>> sum = Function2.lift(test::sum);
        System.out.println(sum.apply(-1, 1));
        System.out.println(sum.apply(-1, 1).get());
        System.out.println(sum.apply(1, 0));
        System.out.println(sum.apply(1, 0).get());
    }

    int sum(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("no negetive are allowed");
        }
        return a + b;
    }


}
