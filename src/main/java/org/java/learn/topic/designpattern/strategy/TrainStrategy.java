package org.java.learn.topic.designpattern.strategy;

/**
 * ClassName: TrainStrategy <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 11:05 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class TrainStrategy implements Strategy {
    @Override
    public void travel() {
        System.out.println("travel by train");
    }
}
