package org.java.learn.topic.classloader;

class Parent2 {
    static int a = 3;

    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {
    static int b = 4;

    static {
        System.out.println("Child2 static block");
    }
}

public class InitializeSequenceTest2 {

    static {
        System.out.println("main static block");
    }

    public static void main(String[] args) {
        // û��new���ʲ���������ʼ����Ҳ���������start�������������̬�����
        Parent2 parent2;
        Child2 child2;
        System.out.println("start");
        parent2 = new Parent2();

        System.out.println(parent2.a);
        // ��ʼ������ʱ���ָ����Ѿ���ʼ�����ʲ��ٳ�ʼ������
        child2 = new Child2();
        System.out.println(child2.b);
    }

}
