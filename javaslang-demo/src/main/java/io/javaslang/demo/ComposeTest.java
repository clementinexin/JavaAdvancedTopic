package io.javaslang.demo;

import javaslang.Function1;

/**
 * Created by daijiajia on 16/7/12.
 */
public class ComposeTest {

    public static void main(String[] args) {
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        Function1<Integer, Integer> plusOneAndmultiplyByTwo = plusOne.andThen(multiplyByTwo);
        System.out.println(plusOneAndmultiplyByTwo.apply(1));

        Function1<Integer, Integer> plusOneAndmultiplyByTwo1 = plusOne.compose(multiplyByTwo);
        System.out.println(plusOneAndmultiplyByTwo1.apply(1));

        Function1<Integer, Integer> plusOneAndmultiplyByTwo2 = multiplyByTwo.compose(plusOne);
        System.out.println(plusOneAndmultiplyByTwo2.apply(1));
    }
}
