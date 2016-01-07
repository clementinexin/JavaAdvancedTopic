package org.java.learn.topic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ConditionTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-06 11:45 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-06 jdai@ created. <br/>
 */
public class ConditionTest {

    static Lock lock = new ReentrantLock();

    static Condition A = lock.newCondition();
    static Condition B = lock.newCondition();
    static Condition C = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try {
                    B.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                while (true) {
                    lock.lock();
                    try {
                        System.out.println("B");
                        C.signal();
                        B.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    C.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                while (true) {
                    lock.lock();
                    try {
                        System.out.println("C");
                        A.signal();
                        C.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        System.out.println("A");
                        B.signal();
                        A.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

    }
}
