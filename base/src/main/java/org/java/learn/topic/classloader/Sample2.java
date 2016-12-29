package org.java.learn.topic.classloader;

public class Sample2 {

    public int v2 = 2;

    public Sample2() {
        System.out.println("calss " + this.getClass().getSimpleName() + "loader by :" + this.getClass().getClassLoader());
    }
}
