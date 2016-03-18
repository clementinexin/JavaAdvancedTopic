package org.java.learn.topic.designpattern.builder;

/**
 * ClassName: AutoBuilder <br/>
 * Description: TODO <br/>
 * Date: 2016-03-18 9:56 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-18 jdai@ created. <br/>
 */
public class AutoBuilder implements VehicleBuilder {

    private String wheel ;
    private String motor;

    @Override
    public void buildWheel() {
        wheel = "wheel";
        System.out.println("build wheel");
    }

    @Override
    public void buildMotor() {
        motor = "motor";
        System.out.println("build motor");
    }

    @Override
    public Vehicle getResult() {
        return new Vehicle(wheel,motor);
    }
}
