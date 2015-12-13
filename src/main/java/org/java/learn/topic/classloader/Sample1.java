package org.java.learn.topic.classloader;

public class Sample1 {

	public int v1 =1;
	
	public Sample1() {
		System.out.println("calss " + this.getClass().getSimpleName() + "loader by :" + this.getClass().getClassLoader());
	}
}
