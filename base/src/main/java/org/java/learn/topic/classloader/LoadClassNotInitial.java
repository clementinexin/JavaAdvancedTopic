package org.java.learn.topic.classloader;


class ClassLoaderTst {
    static {
        System.out.println("ClassLoaderTest static block");
    }
}

public class LoadClassNotInitial {

    public static void main(String[] args) throws ClassNotFoundException {
        // ClassLoader��loadClass�������ܳ�ʼ������
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        loader.loadClass("org.java.learn.topic.classloader.ClassLoaderTst");
        System.out.println("----------------------------------------------");
        Class.forName("org.java.learn.topic.classloader.ClassLoaderTst");
    }

}
