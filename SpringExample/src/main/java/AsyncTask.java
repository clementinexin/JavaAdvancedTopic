import org.springframework.scheduling.annotation.Async;

/**
 * ClassName: AsyncTask <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 13:54 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public class AsyncTask {

    @Async
    public void func() {
        System.out.println("当前执行线程是 " + Thread.currentThread().getName());
    }
}
