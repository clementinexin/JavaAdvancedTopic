package org.java.learn.topic.classloader;

class Parent{
	static int a = 3;
	static {
		System.out.println("Parent static block");
	}
}

class Child extends Parent {
	static int b = 4;
	static {
		System.out.println("Child static block");
	}
}

public class InitializeSequenceTest1 {

	static {
		System.out.println("Main class ststic block");
	}
	
	public static void main(String[] args) {
		System.out.println(Child.b);
	}

}
