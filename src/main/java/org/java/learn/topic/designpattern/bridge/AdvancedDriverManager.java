package org.java.learn.topic.designpattern.bridge;

/**
 * ClassName: AdvancedDriverManager <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 17:08 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class AdvancedDriverManager extends DriverManager {
    @Override
    public void connect() {
        System.out.println("before connect");
        super.connect();
        System.out.println("after connect");
    }
}
