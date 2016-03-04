package org.java.learn.topic.thread;

/**
 * ClassName: ThreadLocalTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-04 14:12 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-04 jdai@ created. <br/>
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    private static ThreadLocal<String> local2 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "hello";
        }
    };

    public static void main(String[] args) {

        for (int i = 0 ;i<3;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int j = local.get();
                    local.set(j);
                    local2.set("world");
                    local2.get();
                }
            }).start();
        }

    }
}
