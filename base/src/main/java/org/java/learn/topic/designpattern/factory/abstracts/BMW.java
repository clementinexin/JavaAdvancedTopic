package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: BMW <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 18:11 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class BMW extends Vehicle {
    public BMW(Wheel wheel, Motor motor) {
        super(wheel, motor);
    }
}
