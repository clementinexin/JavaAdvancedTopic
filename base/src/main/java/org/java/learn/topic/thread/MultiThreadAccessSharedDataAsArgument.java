package org.java.learn.topic.thread;

public class MultiThreadAccessSharedDataAsArgument {

    /**
     * 共享变量作为成员变量，线程类作为内部类通过构造函数实例化共享该成员变量
     */
    static SharedData sharedData = new SharedData(1000);

    public static void main(String[] args) {

        new Thread(new IncrementRunnable(sharedData)).start();
        new Thread(new DecrementRunnable(sharedData)).start();
    }


}

class IncrementRunnable implements Runnable {

    SharedData sharedData;

    public IncrementRunnable(SharedData sharedData) {
        super();
        this.sharedData = sharedData;
    }

    public void run() {
        while (true) {
            sharedData.increment();
        }
    }
}

class DecrementRunnable implements Runnable {
    SharedData sharedData;

    public DecrementRunnable(SharedData sharedData) {
        super();
        this.sharedData = sharedData;
    }

    public void run() {
        while (true) {
            sharedData.decrement();
        }
    }

}
