package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: Vehicle <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 18:10 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Vehicle {

    private Wheel wheel;

    private Motor motor;

    public Vehicle(Wheel wheel, Motor motor) {
        this.wheel = wheel;
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheel=" + wheel +
                ", motor=" + motor +
                '}';
    }
}
