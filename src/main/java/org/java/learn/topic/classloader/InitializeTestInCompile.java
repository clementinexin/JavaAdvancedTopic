package org.java.learn.topic.classloader;

class FinalTest{
	static final int x  = 6/3;
	
	//final类型x的值在编译时即可确定，故不会导致类的初始化
	static{
		System.out.println("FinalTest static block");
	}
}

public class InitializeTestInCompile {

	public static void main(String[] args) {
		System.out.println(FinalTest.x);
	}

}
