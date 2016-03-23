package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: SubjectProxy <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 16:23 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public class SubjectProxy implements InvocationHandler {

    private Subject subject;

    public SubjectProxy() {
    }

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public static Subject newProxyInstance(Subject subject) {
        return (Subject) Proxy.newProxyInstance(SubjectProxy.class.getClassLoader(),new Class[] {Subject.class},new SubjectProxy(subject));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        return method.invoke(subject,args);
    }
}
