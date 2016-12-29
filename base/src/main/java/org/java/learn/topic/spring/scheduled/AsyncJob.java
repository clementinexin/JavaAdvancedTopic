package org.java.learn.topic.spring.scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: AsyncJob <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 14:27 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
@Component
public class AsyncJob {

    @Async
    public Future<Integer> getResult() {
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("async job");
        return new AsyncResult<Integer>(1);
    }
}
