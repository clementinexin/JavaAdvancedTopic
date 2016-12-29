package org.java.learn.topic.thread;

import java.util.concurrent.Semaphore;

/**
 * ClassName: SemphoreTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-06 10:42 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-06 jdai@ created. <br/>
 */
public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

        new Thread(new AcquireTask()).start();
        new Thread(new AcquireTask()).start();
        new Thread(new AcquireTask()).start();
        new Thread(new ReleaseTask()).start();
        new Thread(new AcquireTask()).start();

    }

    static class AcquireTask implements Runnable {
        @Override
        public void run() {
            if (semaphore.tryAcquire()) {
                System.out.println("Thread " + Thread.currentThread().getName() + " accquire success ");
            } else {
                System.out.println("Thread " + Thread.currentThread().getName() + " accquire failed ");
            }
        }
    }

    static class ReleaseTask implements Runnable {
        @Override
        public void run() {
            semaphore.release();
            System.out.println("Thread " + Thread.currentThread().getName() + " release success ");
        }
    }
}
