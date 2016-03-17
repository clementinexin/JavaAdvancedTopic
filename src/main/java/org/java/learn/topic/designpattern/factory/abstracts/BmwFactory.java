package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: BmwFactory <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:57 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class BmwFactory extends VehicleFactory {
    @Override
    public Wheel createWheel() {
        return new BmwWheel();
    }

    @Override
    public Motor createMotor() {
        return new BmwMotor();
    }
}
