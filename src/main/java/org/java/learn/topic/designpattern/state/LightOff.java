package org.java.learn.topic.designpattern.state;

/**
 * ClassName: LightOff <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 16:08 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class LightOff extends State {

    public LightOff(String state) {
        super(state);
    }

    @Override
    public void handle() {
        if ("ON".equals(this.getState())) {
            System.out.println("turn light off");
            this.setState("OFF");
        }
    }
}
