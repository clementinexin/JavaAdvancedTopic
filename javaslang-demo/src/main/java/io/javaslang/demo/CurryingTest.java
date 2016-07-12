package io.javaslang.demo;

import javaslang.Function1;
import javaslang.Function2;

/**
 * Created by daijiajia on 16/7/12.
 */
public class CurryingTest {

    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> add2 = sum.curried().apply(2);
        System.out.println(add2.apply(5));
    }
}
