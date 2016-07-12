package io.javaslang.demo;

import javaslang.Function0;

/**
 * Created by daijiajia on 16/7/12.
 */
public class MemoizationTest {

    public static void main(String[] args) {
        Function0<Double> hashCache = Function0.of(Math::random).memoized();

        System.out.println(hashCache.apply());
        System.out.println(hashCache.apply());
//        then(hashCache.apply()).isEqual(hashCache.apply());
    }
}
