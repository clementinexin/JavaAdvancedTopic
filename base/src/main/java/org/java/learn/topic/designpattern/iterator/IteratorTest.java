package org.java.learn.topic.designpattern.iterator;

/**
 * ClassName: IteratorTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:15 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class IteratorTest {

    public static void main(String[] args) {
        Collection<String> collection = new MyCollection();
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
