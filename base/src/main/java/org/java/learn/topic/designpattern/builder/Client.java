package org.java.learn.topic.designpattern.builder;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-18 9:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-18 jdai@ created. <br/>
 */
public class Client {

    public static void main(String[] args) {
        VehicleBuilder builder = new AutoBuilder();
        Designer designer = new Designer(builder);
        designer.design();
        System.out.println(builder.getResult());
    }
}
