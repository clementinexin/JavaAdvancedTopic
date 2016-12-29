package org.java.learn.topic.thread;

import java.util.Random;
import java.util.UUID;

public class ThreadScopeDataInThreadLocal {

    static ThreadLocal<ThreadLocalData> threadLocal = new ThreadLocal<ThreadLocalData>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                Integer value = new Random().nextInt();
                String name = UUID.randomUUID().toString();
                ThreadLocalData data = new ThreadLocalData(name, value);

                public void run() {
                    System.out.println(Thread.currentThread().getName() + " put " + data);
                    threadLocal.set(data);
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

