package org.java.learn.topic.thread;

public class MultiThreadAccessSharedDateAsField {

    /**
     * 共享变量作为局部变量，各线程共同访问该变量，线程操作封装在该共享变量中
     */
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(1000);

        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    sharedData.increment();
                }
            }
        }).start();

        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    sharedData.decrement();
                }
            }
        }).start();
    }
}
