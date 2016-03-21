package main.java.org.java.learn.topic.designpattern.visitor;

import java.util.List;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-21 17:11 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-21 jdai@ created. <br/>
 */
public class Client {

    public static void main(String[] args) {
        List<Element> elements = ObjectStructure.get();
        for (Element element : elements) {
            element.accept(new VisitorImpl());
        }
    }
}
