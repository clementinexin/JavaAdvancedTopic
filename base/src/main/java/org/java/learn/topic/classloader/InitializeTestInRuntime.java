package org.java.learn.topic.classloader;

import java.util.Random;

class FinalTest1 {
    static final int x = new Random().nextInt(10);

    // final类型x的值在运行时才可确定，故不会导致类的初始化
    static {

        System.out.println("FinalTest1 static block");
    }
}

public class InitializeTestInRuntime {

    public static void main(String[] args) {
        System.out.println(FinalTest1.x);

    }

}
