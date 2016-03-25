package cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ClassName: CacheProxy <br/>
 * Description: TODO <br/>
 * Date: 2016-03-25 15:12 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-25 jdai@ created. <br/>
 */
@Aspect
@Component
public class CacheProxy {

    Logger logger = LoggerFactory.getLogger(CacheProxy.class);

    @Autowired
    Cache cache;

    @Pointcut(value = "@annotation(cache.Query)||@annotation(cache.Cacheable)")
    public void cacheAspect() {

    }

    @Around(value = "cacheAspect()")
    public Object aroundRunning(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Cacheable) {
                if (args.length != 2) {
                    if (logger.isInfoEnabled()) logger.info(String.format("参数长度%s不为2，不允许Cacheable标签",args.length));
                }
                cache.put(args[0],args[1]);
                return null;
            }

            if (annotation instanceof Query) {
                if (args.length != 1) {
                    if (logger.isInfoEnabled()) logger.info(String.format("参数长度%s不为1,不允许Query标签",args.length));
                }
                return cache.get(args[0]);
            }
        }
        return pjp.proceed();
    }

}
