package org.java.learn.topic.designpattern.builder;

/**
 * ClassName: Vehicle <br/>
 * Description: TODO <br/>
 * Date: 2016-03-18 9:53 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-18 jdai@ created. <br/>
 */
public class Vehicle {
    private String wheel;

    private String motor;

    public Vehicle(String wheel, String motor) {
        this.wheel = wheel;
        this.motor = motor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheel='" + wheel + '\'' +
                ", motor='" + motor + '\'' +
                '}';
    }
}
