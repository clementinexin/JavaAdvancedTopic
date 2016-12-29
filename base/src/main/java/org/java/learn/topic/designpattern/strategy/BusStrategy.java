package org.java.learn.topic.designpattern.strategy;

/**
 * ClassName: BusStrategy <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 11:06 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class BusStrategy implements Strategy {
    @Override
    public void travel() {
        System.out.println("travel by bus");
    }
}
