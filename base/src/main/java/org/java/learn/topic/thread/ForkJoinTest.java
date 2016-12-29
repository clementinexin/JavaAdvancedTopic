package org.java.learn.topic.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * ClassName: ForkJoinTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-06 11:46 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-06 jdai@ created. <br/>
 */
public class ForkJoinTest {

    static class CalcTask extends RecursiveTask<Integer> {

        private final static int THRESHOLD = 2;

        private int start;

        private int end;

        public CalcTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            int sum = 0;

            boolean justdoit = false;
            if (end - start <= THRESHOLD) {
                justdoit = true;
            }

            if (justdoit) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                int middle = (start + end) / 2;
                CalcTask left = new CalcTask(start, middle);
                CalcTask right = new CalcTask(middle + 1, end);

                left.fork();
                right.fork();

                sum = left.join() + right.join();

            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Future<Integer> result = forkJoinPool.submit(new CalcTask(1, 4));
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
