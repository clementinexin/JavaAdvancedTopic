package org.java.learn.topic.spring.scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

/**
 * ClassName: IAsyncJob <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 15:18 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
public interface IAsyncJob {
    AsyncResult<Integer> getResult();
}
