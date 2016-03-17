package org.java.learn.topic.designpattern.factory.method;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:33 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Client {

    public static void main(String[] args) {
        new CarFactory().produce();
        new BusFactory().produce();
    }
}
