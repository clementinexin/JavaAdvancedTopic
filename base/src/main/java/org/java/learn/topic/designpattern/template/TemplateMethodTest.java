package org.java.learn.topic.designpattern.template;

/**
 * ClassName: TemplateMethodTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 14:00 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        CaffeineBeverage customer = new CustomerCaffeineBeverage();
        customer.prepareRecipe();
    }

}
