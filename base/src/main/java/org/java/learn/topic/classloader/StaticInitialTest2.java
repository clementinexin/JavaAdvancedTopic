package org.java.learn.topic.classloader;

public class StaticInitialTest2 {

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s.count1);
        System.out.println(s.count2);
    }

    static class Singleton {


        public static int count1;

        public static int count2 = 0;

        public static Singleton INSTANCE = new Singleton();


        private Singleton() {
            count1++;
            count2++;
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }

    }
}


