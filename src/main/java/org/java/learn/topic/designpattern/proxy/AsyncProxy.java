package org.java.learn.topic.designpattern.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.reflect.FastClass;
import org.springframework.cglib.reflect.FastMethod;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: AsyncProxy <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 9:48 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
//@Aspect
//@Component
public class AsyncProxy {


    //    @Autowired
    private AsyncManager asyncManager;

    public AsyncManager getAsyncManager() {
        return asyncManager;
    }

    public void setAsyncManager(AsyncManager asyncManager) {
        this.asyncManager = asyncManager;
    }

    //    @Pointcut(value = "@annotation(org.java.learn.topic.designpattern.proxy.Async)")
    private void asyncAspect() {
    }

    //    @Around(value = "asyncAspect()")
    public void aroundRunning(final ProceedingJoinPoint pjp) {
        final Object[] args = pjp.getArgs();

        final MethodSignature signature = (MethodSignature) pjp.getSignature();

        asyncManager.doAsync(new AsyncTask() {
            @Override
            public void doAsync() {
                /*
                try {
                    pjp.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                */
                Class service =  signature.getDeclaringType();
                FastClass fastClass = FastClass.create(service);
                FastMethod method = fastClass.getMethod(signature.getMethod());
                try {
                    method.invoke(pjp.getTarget(),args);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
