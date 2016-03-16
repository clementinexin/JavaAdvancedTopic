package org.java.learn.topic.designpattern.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * ClassName: AsyncMain <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 10:11 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class AsyncMain {

    public static void main(String[] args) {
        /*
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
        context.load("context.xml");

        context.refresh();
        context.start();
        */

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        AsyncLogic logic = (AsyncLogic) context.getBean("asyncLogicImpl");
        AsyncLogicImpl logic = (AsyncLogicImpl) context.getBean("asyncLogicImpl");
        logic.func();

        AsyncManager asyncManager = (AsyncManager) context.getBean("asyncManager");
//        asyncManager.doAsync(new AsyncTaskObject());
    }
}
