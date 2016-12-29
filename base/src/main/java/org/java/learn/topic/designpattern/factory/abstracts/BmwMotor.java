package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: BmwMotor <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 18:02 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class BmwMotor extends Motor {
    public BmwMotor(String name) {
        super(name);
    }

    public BmwMotor() {
        this.name = "BMW Motor";
    }
}
