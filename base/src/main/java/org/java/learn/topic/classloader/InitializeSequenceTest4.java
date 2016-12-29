package org.java.learn.topic.classloader;

class Parent4 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }
}

class Child4 extends Parent4 {
    static int b = 4;

    static {
        System.out.println("Child3 static block");
    }
}

public class InitializeSequenceTest4 {

    static {
        System.out.println("main static block");
    }

    public static void main(String[] args) {
        // û��new���ʲ���������ʼ����Ҳ���������start�������������̬�����
        Child4 child4;
        System.out.println("start");

//		child4 = new Child4();
        // ��̬����a�����ڵ�ǰ��Child���ж��壬��˲��ᵼ��Child��ĳ�ʼ��
        System.out.println(Child4.a);
    }

}
