package org.java.learn.topic.thread;

/**
 * ClassName: PockerInTurnTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-07 10:52 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-07 jdai@ created. <br/>
 */
public class PockerInTurnTest1 {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("A");
                }
            });
            thread1.start();
            thread1.join();

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("B");
                }
            });
            thread2.start();
            thread2.join();

            Thread thread3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("C");
                }
            });
            thread3.start();
            thread3.join();
        }
    }
}
