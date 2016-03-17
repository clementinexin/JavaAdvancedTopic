package org.java.learn.topic.designpattern.factory.method;

/**
 * ClassName: CarFactory <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:32 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle produce() {
        return new Car();
    }
}
