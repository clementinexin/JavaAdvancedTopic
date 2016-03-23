import org.springframework.scheduling.annotation.Async;

/**
 * ClassName: AsyncTaskInterface <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 15:54 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public interface AsyncTaskInterface {
    @Async
    public void func() ;
}
