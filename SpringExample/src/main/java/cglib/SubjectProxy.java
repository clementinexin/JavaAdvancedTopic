package cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ClassName: SubjectProxy <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 16:58 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public class SubjectProxy implements MethodInterceptor {

    public static RealSubject newProxyInstance(Class target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(new SubjectProxy());
        return (RealSubject) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke");
        return methodProxy.invokeSuper(o,objects);
    }
}
