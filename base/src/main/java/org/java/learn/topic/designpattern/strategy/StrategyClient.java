package org.java.learn.topic.designpattern.strategy;

/**
 * ClassName: StrategyClient <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 11:07 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class StrategyClient {

    public static void main(String[] args) {
        Travel travel = new Travel();
        travel.setStrategy(new FlightStrategy());
        travel.travel();

        travel.setStrategy(new TrainStrategy());
        travel.travel();

        travel.setStrategy(new BusStrategy());
        travel.travel();
    }
}
