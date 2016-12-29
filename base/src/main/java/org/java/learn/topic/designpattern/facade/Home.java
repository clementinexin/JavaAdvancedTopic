package org.java.learn.topic.designpattern.facade;

/**
 * ClassName: Home <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 16:49 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class Home {
    private Light light;

    private TV tv;

    private Aircondition aircondition;

    public Home(Light light, TV tv, Aircondition aircondition) {
        this.light = light;
        this.tv = tv;
        this.aircondition = aircondition;
    }

    public void back() {
        System.out.println("back home");
        light.on();
        aircondition.on();
        tv.on();
    }

    public void leave() {
        System.out.println("leave home");
        light.off();
        aircondition.off();
        tv.off();
    }
}
