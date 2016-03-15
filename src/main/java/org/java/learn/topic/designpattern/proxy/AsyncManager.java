package org.java.learn.topic.designpattern.proxy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ClassName: AsyncManager <br/>
 * Description: TODO <br/>
 * Date: 2016-03-15 17:17 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-15 jdai@ created. <br/>
 */
public class AsyncManager {

    private int depth = 100;

    private BlockingQueue<AsyncTask> tasks = new LinkedBlockingQueue<AsyncTask>(depth);

    private int threadNum = 100;

    private Boolean initial = Boolean.FALSE;

    public void init() {
        for (int i=0;i<threadNum;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            tasks.take().doAsync();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        initial = Boolean.TRUE;
    }

    public void doAsync(AsyncTask task) {
        if (!initial) init();
        try {
            tasks.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
