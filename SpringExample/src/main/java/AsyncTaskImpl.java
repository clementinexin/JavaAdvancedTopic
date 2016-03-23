/**
 * ClassName: AsyncTaskImpl <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 15:54 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public class AsyncTaskImpl implements AsyncTaskInterface {

    @Override
    public void func() {
        System.out.println(Thread.currentThread().getName());
    }
}
