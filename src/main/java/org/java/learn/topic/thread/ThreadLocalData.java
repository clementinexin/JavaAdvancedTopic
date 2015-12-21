package org.java.learn.topic.thread;

public class ThreadLocalData {
	
	private String name;
	private Integer account;
	public ThreadLocalData(String name, Integer account) {
		this.name = name;
		this.account = account;
	}
	@Override
	public String toString() {
		return "ThreadLocalData [name=" + name + ", account=" + account + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	
	
}
