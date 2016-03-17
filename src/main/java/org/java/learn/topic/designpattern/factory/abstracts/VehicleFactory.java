package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: VehicleFactory <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:54 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public abstract class VehicleFactory {

    public abstract Wheel createWheel();

    public abstract Motor createMotor();

    public final Vehicle assemble() {
        return new Vehicle(createWheel(),createMotor());
    }

}
