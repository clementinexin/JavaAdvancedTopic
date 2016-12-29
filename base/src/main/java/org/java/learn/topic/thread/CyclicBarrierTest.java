package org.java.learn.topic.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ClassName: CyclicBarrierTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-06 10:19 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-06 jdai@ created. <br/>
 */
public class CyclicBarrierTest {
    static int i = 10;
    static int data[] = new int[1024 * i];
    static CyclicBarrier barrier = new CyclicBarrier(12);

    static {
        for (int j = 0; j < 1024 * i; j++) {
            data[j] = new Random().nextInt(100);
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        for (int j = 0; j < i; j++) {
            int start = j * 1024;
            int end = (j + 1) * 1024 - 1;

            Thread thread = new Thread(new CalcTask(barrier, data, start, end));
            thread.start();
        }
        System.out.println("all the threads wait ");
        barrier.await();
        System.out.println("all the threads calculate ,print the result");
    }

    static class CalcTask implements Runnable {
        private CyclicBarrier barrier;
        private int[] data;
        private int start;
        private int end;

        public CalcTask(CyclicBarrier barrier, int[] data, int start, int end) {
            this.barrier = barrier;
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += data[i];
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("Thread name : " + Thread.currentThread().getName() + ", sum = " + sum + " , avg = " + sum / (end + 1 - start));
        }
    }


}
