package org.java.learn.topic.thread;


public class SharedData {

    private int count;

    public SharedData(int count) {
        super();
        this.count = count;
    }

    public synchronized void increment() {
        System.out.print("increment : ");
        System.out.println(count++);
    }

    public synchronized void decrement() {
        System.out.print("decrement : ");
        System.out.println(count--);
    }
}


