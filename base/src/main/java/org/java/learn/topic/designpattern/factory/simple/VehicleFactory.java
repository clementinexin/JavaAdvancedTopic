package org.java.learn.topic.designpattern.factory.simple;

/**
 * ClassName: VehicleFactory <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 16:54 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class VehicleFactory {

    public Vehicle produce(VehicleType type) {
        switch (type) {
            case CAR:
                return new Car();
            case BUS:
                return new Bus();
            case BIKE:
                return new Bike();
            default:
                return null;
        }
    }
}
