package org.java.learn.topic.classloader;

public class StaticInitialTest1 {

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s.count1);
        System.out.println(s.count2);
    }

}


class Singleton {

    public static Singleton INSTANCE = new Singleton();

    public static int count1;

    public static int count2 = 0;

    private Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

}
