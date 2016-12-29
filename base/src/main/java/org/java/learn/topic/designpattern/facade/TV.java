package org.java.learn.topic.designpattern.facade;

/**
 * ClassName: TV <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 16:44 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class TV implements Switch {
    @Override
    public void on() {
        System.out.println("TV on");
    }

    @Override
    public void off() {
        System.out.println("TV off");
    }
}
