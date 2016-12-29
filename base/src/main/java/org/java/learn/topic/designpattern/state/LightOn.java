package org.java.learn.topic.designpattern.state;

/**
 * ClassName: LightOn <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 16:06 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class LightOn extends State {

    public LightOn(String state) {
        super(state);
    }

    @Override
    public void handle() {
        if ("OFF".equals(this.getState())) {
            System.out.println("turn light on");
            this.setState("ON");
        }
    }
}
