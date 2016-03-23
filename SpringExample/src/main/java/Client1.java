import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-23 11:41 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-23 jdai@ created. <br/>
 */
public class Client1 {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\opensource");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
        context.load("context-1.xml");
        context.refresh();
        context.start();

        AsyncTask task = (AsyncTask) context.getBean("asyncTask");
        task.func();
    }
}
