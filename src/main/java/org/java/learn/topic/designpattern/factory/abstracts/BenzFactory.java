package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: BenzFactory <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:58 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class BenzFactory extends VehicleFactory {

    @Override
    public Wheel createWheel() {
        return new BenzWheel();
    }

    @Override
    public Motor createMotor() {
        return new BenzMotor();
    }
}
