package cache;

import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * ClassName: Main <br/>
 * Description: TODO <br/>
 * Date: 2016-03-25 16:40 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-25 jdai@ created. <br/>
 */
public class Main {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
        context.load("cache.xml");
        context.refresh();
        context.start();

        Gateway gateway = (Gateway) context.getBean("gateway");
        System.out.println(gateway.get(1));
        System.out.println(gateway.get(2));
    }

}
