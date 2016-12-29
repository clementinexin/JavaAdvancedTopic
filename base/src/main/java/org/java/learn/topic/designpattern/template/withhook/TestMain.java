package org.java.learn.topic.designpattern.template.withhook;

/**
 * ClassName: TestMain <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 14:12 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class TestMain {

    public static void main(String[] args) {
        CaffeineBeverageWithHook customer = new CustomerCoffeineBeverageWithHook();
        customer.prepareRecipe();
    }
}
