package org.java.learn.topic.thread;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: CordinateWithCountDownLatch <br/>
 * Description: TODO <br/>
 * Date: 2016-03-25 14:47 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-25 jdai@ created. <br/>
 */
public class CordinateWithCountDownLatch {

    static long sum,sum1,sum2,sum3= 0;

    public static void main(String[] args) {
        final long loop = 100000000;
        final CountDownLatch latch = new CountDownLatch(3);

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0;i<loop;i++) {
                    sum1 +=1;
                }
                System.out.println(Thread.currentThread().getName() + " 计算完成 " + sum1);
                latch.countDown();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0;i<loop;i++) {
                    sum2 +=1;
                }
                System.out.println(Thread.currentThread().getName() + " 计算完成 " + sum2);
                latch.countDown();
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0;i<loop;i++) {
                    sum3 +=1;
                }
                System.out.println(Thread.currentThread().getName() + " 计算完成 " + sum3);
                latch.countDown();
            }
        });

        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    sum = sum1+sum2+sum3;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 计算完成 " + sum);
            }
        });

        a.start();
        b.start();
        c.start();
        d.start();

    }
}
