package org.java.learn.topic.gc;

/**
 * ClassName: DeadCircle <br/>
 * Description: TODO <br/>
 * Date: 2016-03-10 17:37 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-10 jdai@ created. <br/>
 */
public class DeadCircle {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    doSomething();
                }
            }
        }).start();
    }

   private static void doSomething() {

    }
}
