package org.java.learn.topic.thread;

import java.util.Random;

public class ThreadScopeDataWithMoreThanOneFieldInThreadLocal {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                Integer value = new Random().nextInt();

                public void run() {
                    System.out.println(Thread.currentThread().getName() + " put " + value);
                    threadLocal.set(value);
                    new ThreadOutputer1().output();
                    new ThreadOutputer2().output();
                }
            }).start();
        }
    }

    static class ThreadOutputer1 {
        public void output() {
            System.out.println(Thread.currentThread().getName() + " get " + threadLocal.get());
        }
    }

    static class ThreadOutputer2 {
        public void output() {
            System.out.println(Thread.currentThread().getName() + " get " + threadLocal.get());
        }
    }

}

