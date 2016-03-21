package main.java.org.java.learn.topic.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: ObjectStructure <br/>
 * Description: TODO <br/>
 * Date: 2016-03-21 17:08 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-21 jdai@ created. <br/>
 */
public class ObjectStructure {

    public static List<Element> get() {
        List<Element> elements = new ArrayList<Element>();
        for (int i = 0;i < 10;i ++) {
            int r = new Random(10).nextInt();
            if (r < 5) elements.add(new ElementA());
            else elements.add(new ElementB());
        }
        return elements;
    }
}
