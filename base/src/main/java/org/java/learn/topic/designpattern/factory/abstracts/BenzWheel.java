package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: BenzWheel <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 18:03 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class BenzWheel extends Wheel {
    public BenzWheel(String name) {
        super(name);
    }

    public BenzWheel() {
        this.name = "Benz Wheel";
    }
}
