package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: BmeWheel <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class BmwWheel extends Wheel {

    public BmwWheel(String name) {
        super(name);
    }

    public BmwWheel() {
        this.name = "BMW Wheel";
    }
}
