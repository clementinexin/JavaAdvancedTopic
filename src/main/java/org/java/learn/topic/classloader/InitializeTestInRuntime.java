package org.java.learn.topic.classloader;

import java.util.Random;

class FinalTest1 {
	static final int x = new Random().nextInt(10);

	// final����x��ֵ������ʱ�ſ�ȷ�����ʲ��ᵼ����ĳ�ʼ��
	static {
		System.out.println("FinalTest1 static block");
	}
}

public class InitializeTestInRuntime {

	public static void main(String[] args) {
		System.out.println(FinalTest1.x);

	}

}
