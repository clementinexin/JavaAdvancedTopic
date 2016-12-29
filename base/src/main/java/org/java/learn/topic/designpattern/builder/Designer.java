package org.java.learn.topic.designpattern.builder;

/**
 * ClassName: Designer <br/>
 * Description: TODO <br/>
 * Date: 2016-03-18 9:55 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-18 jdai@ created. <br/>
 */
public class Designer {

    private VehicleBuilder builder;

    public Designer(VehicleBuilder builder) {
        this.builder = builder;
    }

    public void design() {
        builder.buildWheel();
        builder.buildMotor();
    }
}
