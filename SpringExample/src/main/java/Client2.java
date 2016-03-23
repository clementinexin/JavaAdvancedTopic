import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * ClassName: Client2 <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 15:56 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public class Client2 {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
        context.load("context-2.xml");
        context.refresh();
        context.start();

        AsyncTaskInterface task = (AsyncTaskInterface) context.getBean("asyncTask");
        task.func();
    }
}
