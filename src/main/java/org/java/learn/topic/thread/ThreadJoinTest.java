package org.java.learn.topic.thread;

/**
 * ClassName: ThreadJoinTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-04 15:22 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-04 jdai@ created. <br/>
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
//        Thread.currentThread().join();

        Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " thread exited");


    }
}
