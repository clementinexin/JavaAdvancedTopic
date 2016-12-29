package org.java.learn.topic.designpattern.builder;

/**
 * ClassName: VehicleBuilder <br/>
 * Description: TODO <br/>
 * Date: 2016-03-18 9:52 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-18 jdai@ created. <br/>
 */
public interface VehicleBuilder {

    public void buildWheel();

    public void buildMotor();

    public Vehicle getResult();
}
