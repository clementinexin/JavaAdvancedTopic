package org.java.learn.topic.designpattern.proxy;

import org.springframework.stereotype.Component;

/**
 * ClassName: AsyncTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 10:10 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
@Component
public class AsyncLogicImpl
//        implements AsyncLogic
{

    @Async
//    @Override
    public void func() {
        System.out.println("开启线程: " + Thread.currentThread().getName());
    }
}
