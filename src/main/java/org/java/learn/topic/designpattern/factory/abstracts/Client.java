package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 18:08 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Client {

    public static void main(String[] args) {
        BmwFactory bmwFactory = new BmwFactory();
        System.out.println(bmwFactory.assemble());
        BenzFactory benzFactory = new BenzFactory();
        System.out.println(benzFactory.assemble());

    }
}
