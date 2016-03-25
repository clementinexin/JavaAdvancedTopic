package org.java.learn.topic.spring.scheduled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * ClassName: AsyncMain <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 14:27 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
public class AsyncMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        AsyncJob job =  context.getBean(AsyncJob.class);
        System.out.println(Thread.currentThread().getName());

        Future<Integer> future = job.getResult();
        System.out.println("main thread exit");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
