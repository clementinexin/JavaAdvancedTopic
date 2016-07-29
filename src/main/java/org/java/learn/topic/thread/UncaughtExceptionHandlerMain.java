package org.java.learn.topic.thread;

/**
 * Created by daijiajia on 16/7/28.
 */
public class UncaughtExceptionHandlerMain {

    public static void main(String[] args) throws InterruptedException {


        final Runnable run = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    System.out.println(i++);

                    throw new RuntimeException("ex");
                }
            }
        };
        Thread t = new Thread(run);

        final Runnable run1 = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i++);

                }
            }
        };

        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("caught ex");
                Thread.interrupted();
                t = new Thread(run1);
                t.start();
            }
        });

        t.start();

        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }


}
