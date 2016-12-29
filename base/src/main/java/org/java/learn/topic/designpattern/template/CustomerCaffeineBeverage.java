package org.java.learn.topic.designpattern.template;

/**
 * ClassName: CustomerCaffeineBeverage <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 13:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class CustomerCaffeineBeverage extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("brew with hot water");
    }

    @Override
    public void addCondiments() {
        System.out.println("add sugar");
    }
}
