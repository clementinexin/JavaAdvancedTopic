package org.java.learn.topic.thread;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: CountDownLatchTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-05 17:07 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-05 jdai@ created. <br/>
 */
public class CountDownLatchTest {
    static int i = 10;
    final static CountDownLatch num = new CountDownLatch(i);
    public static void main(String[] args) throws InterruptedException {

        for (int j = 0;j < i;j ++) {

            Thread thread = new Thread(new AcquireTask(num));
            thread.start();
//            thread.join();
        }

        for (int k = 0;k < i-2;k ++) {
            Thread thread = new Thread(new ReleaseTask(num));
            thread.start();
            thread.join();
        }
    }

    static class AcquireTask implements Runnable {

        private CountDownLatch num;

        public AcquireTask(CountDownLatch num) {
            this.num = num;
        }

        @Override
        public void run() {
            try {

                num.await();
                System.out.println("acquire all resource");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ReleaseTask implements Runnable {

        private CountDownLatch num;

        public ReleaseTask(CountDownLatch num) {
            this.num = num;
        }

        @Override
        public void run() {
            num.countDown();
            System.out.println("release a resource");
        }
    }
}
