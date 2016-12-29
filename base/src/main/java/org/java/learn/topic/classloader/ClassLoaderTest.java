package org.java.learn.topic.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str = "";
        System.out.println(str.getClass().getClassLoader());

        System.out.println(new test().getClass().getClassLoader());

    }

}

class test {

}
