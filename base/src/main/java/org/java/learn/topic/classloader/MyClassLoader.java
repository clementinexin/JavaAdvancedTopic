package org.java.learn.topic.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MyClassLoader extends ClassLoader {

    private String name;

    private String path;

    private String fileType = ".class";

    public MyClassLoader(String name) {
        super();
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        try {
            return Files.readAllBytes(Paths.get(path + name.replace(".", "\\") + fileType));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyClassLoader [name=" + name + "]";
    }

    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.path = "D:\\exercise\\lib1\\";

        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        loader2.path = "D:\\exercise\\lib2\\";

        MyClassLoader loader3 = new MyClassLoader(null, "loader3");
        loader3.path = "D:\\exercise\\otherlib\\";

        test(loader1);
        test(loader3);
    }

    public static void test(ClassLoader loader) {

        try {
            Class clazz = loader.loadClass("Sample1");
            Object object = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
