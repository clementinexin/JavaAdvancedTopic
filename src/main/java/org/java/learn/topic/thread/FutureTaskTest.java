package org.java.learn.topic.thread;

import java.util.concurrent.*;

/**
 * ClassName: FutureTaskTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-07 17:17 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-07 jdai@ created. <br/>
 */
public class FutureTaskTest {

    static FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            return 0;
        }
    });
    public static void main(String[] args) {

        try {
            future.get(0, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
