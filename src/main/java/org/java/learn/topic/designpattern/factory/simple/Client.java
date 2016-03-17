package org.java.learn.topic.designpattern.factory.simple;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:02 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Client {

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        factory.produce(VehicleType.BIKE);
        factory.produce(VehicleType.BUS);
        factory.produce(VehicleType.CAR);
    }
}
