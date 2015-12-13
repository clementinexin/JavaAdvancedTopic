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
		// 没有new，故不会主动初始化，也就是先输出start而不是先输出静态代码块
		Child4 child4;
		System.out.println("start");
		
//		child4 = new Child4();
		// 静态变量a并非在当前的Child类中定义，因此不会导致Child类的初始化
		System.out.println(Child4.a);
	}

}
