package org.java.learn.topic.thread;

/**
 * Created by daijiajia on 16/5/12.
 */
public class ThreadInterruptMain {

    private static volatile boolean interruptBySelf = false;


    public static void main(String[] args) {


        final Thread roundRobinThread = new Thread(new Runnable() {


            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                    if (interruptBySelf) {

                        System.out.println(Thread.currentThread().getName() + " Interrupt by self");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " Interrupt by others");
                    }
//                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Exit");
            }
        });

        Thread wakeupThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleep 5s");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
                if (roundRobinThread.isAlive()) {
                    System.out.println(Thread.currentThread().getName() + " interrupt " + roundRobinThread.getName());
                    interruptBySelf = true;
                    roundRobinThread.interrupt();
                }

            }
        });

        roundRobinThread.start();
        wakeupThread.start();

    }
}
