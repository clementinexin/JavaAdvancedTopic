package org.java.learn.topic.spring.core;

import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * ClassName: MethodInvokeFactoryBeanTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-20 13:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-20 jdai@ created. <br/>
 */
public class MethodInvokeFactoryBeanTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
        ClassPathResource resource = new ClassPathResource("MethodInvokingFactoryBeanTest.xml");
//        FileSystemResource resource = new FileSystemResource("MethodInvokingFactoryBeanTest.xml");
        context.load(resource);
        context.refresh();
        context.start();

        User user = (User) context.getBean("objectGetByMethod");
        System.out.println(user.getName());

        User user1 = (User) context.getBean("objectGetByStaticMethod");
        System.out.println(user1.getName());
    }
}
