package org.java.learn.topic.designpattern.state;

/**
 * ClassName: Context <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 16:09 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Context {

    State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        this.handle();
    }

    public void handle() {
        state.handle();
    }
}
