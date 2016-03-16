package org.java.learn.topic.designpattern.proxy;

/**
 * ClassName: AsyncTaskObject <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 10:07 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class AsyncTaskObject extends AsyncTask {
    @Override
    public void doAsync() {
        System.out.println("开启线程: " + Thread.currentThread().getName());
    }
}
