package io.javaslang.demo;

import javaslang.Function2;

/**
 * Created by daijiajia on 16/7/11.
 */
public class FunctionTest {

    Function2<String, String, String> function22 = (s1, s2) -> s1 + " " + s2;

    public static void main(String[] args) {
        Function2<String, String, String> function2 = (s1, s2) -> s1 + s2;
        System.out.println(function2.apply("Hello" + "World!"));

        Function2<String, String, String> function21 = new Function2<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        };

        Function2<String, String, String> function23 = Function2.of(function21);
    }

    public void func2() {
//        Function2<String, String, String> function23 = Function2.of(this::function22);
    }
}
