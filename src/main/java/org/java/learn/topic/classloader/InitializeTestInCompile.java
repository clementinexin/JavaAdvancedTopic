package org.java.learn.topic.classloader;

class FinalTest{
	static final int x  = 6/3;
	
	//final����x��ֵ�ڱ���ʱ����ȷ�����ʲ��ᵼ����ĳ�ʼ��
	static{
		System.out.println("FinalTest static block");
	}
}

public class InitializeTestInCompile {

	public static void main(String[] args) {
		System.out.println(FinalTest.x);
	}

}
