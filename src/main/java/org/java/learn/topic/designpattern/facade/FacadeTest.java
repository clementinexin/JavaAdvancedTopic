package org.java.learn.topic.designpattern.facade;

/**
 * ClassName: FacadeTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 16:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class FacadeTest {

    public static void main(String[] args) {
        Light light = new Light();
        Aircondition aircondition = new Aircondition();
        TV tv = new TV();
        Home home = new Home(light,tv,aircondition);
        home.back();
        home.leave();
    }
}
