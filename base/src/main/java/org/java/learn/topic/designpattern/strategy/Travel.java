package org.java.learn.topic.designpattern.strategy;

/**
 * ClassName: Travel <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 11:06 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Travel {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        strategy.travel();
    }
}
