package org.java.learn.topic.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by daijiajia on 16/7/29.
 */
public class ThreadFactoryMain {

    public static void main(String[] args) {

        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable r) {

                Thread t = new Thread(r);
                /*
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("caught ex");
                        System.out.println(t.isAlive());
                        t.resume();
                    }
                });
                */
                return t;
            }
        };


        Executor pool = Executors.newFixedThreadPool(1, factory);
        pool.execute(run);


    }

    static Runnable run = new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
            System.out.println(Integer.parseInt("123"));
            System.out.println(Integer.parseInt("x12"));
            System.out.println(Integer.parseInt("456"));
        }
    };


    static class ExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            t = new Thread(run);
            t.start();
        }
    }


}
