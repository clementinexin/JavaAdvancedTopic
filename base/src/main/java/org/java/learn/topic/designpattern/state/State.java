package org.java.learn.topic.designpattern.state;

/**
 * ClassName: State <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 16:05 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public abstract class State {
    private String state;

    public State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public abstract void handle();
}
