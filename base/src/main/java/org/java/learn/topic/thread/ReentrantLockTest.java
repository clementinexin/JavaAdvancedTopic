package org.java.learn.topic.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ReentrencedLockTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-06 11:43 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-06 jdai@ created. <br/>
 */
public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("enter A");
                lock.lock();
                lock.lock();
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " lock " + lock.getHoldCount());
                System.out.println(lock.getQueueLength() + " Threads wait on " + Thread.currentThread().getName());
                lock.unlock();
                lock.unlock();
                lock.unlock();
                System.out.println("exit A");
            }
        });
        A.setName("A");
        A.start();

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("enter B");
                lock.lock();
                System.out.println("exit B");
            }
        });
        B.setName("B");
        B.start();
        B.interrupt();

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("enter C");
                lock.lock();
                System.out.println("exit C");
            }
        });

        C.setName("C");
        C.start();
        C.interrupt();
    }
}
