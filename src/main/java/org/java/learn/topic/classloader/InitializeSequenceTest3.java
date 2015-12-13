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
		// 没有new，故不会主动初始化，也就是先输出start而不是先输出静态代码块
		Child3 child3;
		System.out.println("start");
		
		// 初始化子类时发现父类还没有初始化，故先初始化父类
		child3 = new Child3();
		System.out.println(child3.b);
	}

}
