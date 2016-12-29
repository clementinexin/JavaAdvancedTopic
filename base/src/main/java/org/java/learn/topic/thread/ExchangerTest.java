package org.java.learn.topic.thread;

import java.util.concurrent.Exchanger;

/**
 * ClassName: ExchangerTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-06 11:23 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-06 jdai@ created. <br/>
 */
public class ExchangerTest {
    static Exchanger<String> exchanger = new Exchanger<String>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = "abcde";
                System.out.println("Before exchange : Thread " + Thread.currentThread().getName() + " value : " + s);
                try {
                    s = exchanger.exchange(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("After exchange : Thread " + Thread.currentThread().getName() + " value : " + s);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = "12345";
                System.out.println("Before exchange : Thread " + Thread.currentThread().getName() + " value : " + s);
                try {
                    s = exchanger.exchange(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("After exchange : Thread " + Thread.currentThread().getName() + " value : " + s);
            }
        }).start();

    }
}
