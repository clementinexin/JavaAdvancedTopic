package cglib;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 17:07 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public class Client {
    public static void main(String[] args) {
        SubjectProxy.newProxyInstance(RealSubject.class).func();
    }
}
