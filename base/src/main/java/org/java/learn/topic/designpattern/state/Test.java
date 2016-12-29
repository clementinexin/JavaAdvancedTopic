package org.java.learn.topic.designpattern.state;

/**
 * ClassName: Test <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 16:11 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new LightOn("OFF"));
        context.setState(new LightOff("ON"));
    }
}
