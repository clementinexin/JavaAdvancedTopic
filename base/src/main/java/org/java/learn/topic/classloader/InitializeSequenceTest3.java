package org.java.learn.topic.classloader;

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }
}

class Child3 extends Parent3 {
    static int b = 4;

    static {
        System.out.println("Child3 static block");
    }
}

public class InitializeSequenceTest3 {

    static {
        System.out.println("main static block");
    }

    public static void main(String[] args) {
        // û��new���ʲ���������ʼ����Ҳ���������start�������������̬�����
        Child3 child3;
        System.out.println("start");

        // ��ʼ������ʱ���ָ��໹û�г�ʼ�������ȳ�ʼ������
        child3 = new Child3();
        System.out.println(child3.b);
    }

}
