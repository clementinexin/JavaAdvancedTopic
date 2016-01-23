package org.java.learn.topic.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 16/1/23.
 */
public class StopThreadTest {

    private static boolean stopThread = false;
    public static void main(String[] args) throws InterruptedException {

        Thread backGroudThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopThread) {
                    System.out.println(i++);
                }
            }
        });

        backGroudThread.start();

        TimeUnit.SECONDS.sleep(1);

        stopThread = true;

    }


}
