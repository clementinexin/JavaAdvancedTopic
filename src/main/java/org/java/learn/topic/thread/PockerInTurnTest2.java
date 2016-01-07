package org.java.learn.topic.thread;

import java.util.concurrent.Semaphore;

/**
 * ClassName: PockerInTurnTest2 <br/>
 * Description: TODO <br/>
 * Date: 2016-01-07 11:19 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-07 jdai@ created. <br/>
 */
public class PockerInTurnTest2 {

    static Semaphore a = new Semaphore(1);
    static Semaphore b = new Semaphore(1);
    static Semaphore c = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
            b.acquire();
            c.acquire();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            a.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A");
                        b.release();
                    }

                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            b.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("B");
                        c.release();
                    }

                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            c.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("C");
                        a.release();
                    }

                }
            }).start();

//            C.start();
//            B.start();
//            A.start();
        }
}
