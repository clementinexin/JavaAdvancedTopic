package org.java.learn.topic.designpattern.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ClassName: AsyncAnnotationProcessor <br/>
 * Description: TODO <br/>
 * Date: 2016-03-15 17:39 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-15 jdai@ created. <br/>
 */
public class AsyncAnnotationProcessor implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(AsyncAnnotationProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class clazz = null;
        if (AopUtils.isAopProxy(bean)) {
            clazz = AopUtils.getTargetClass(bean);
        } else {
            clazz = bean.getClass();
        }

        Annotation async = clazz.getAnnotation(Async.class);
        if (async != null) {
            if (logger.isInfoEnabled()) logger.info(clazz.getSimpleName() + " 类中所有的方法都被标注为Async执行的方法");
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(Async.class) != null) {
                if (logger.isInfoEnabled())
                    logger.info(clazz.getSimpleName() + " 类中的方法 " + method.getName() + " 被标注为Async执行的方法");
            }
        }
        return bean;
    }
}
