package org.java.learn.topic.designpattern.mediator;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 11:32 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public class Client {

    public static void main(String[] args) {
        MessageServer mediator = new MessageServer();
        SystemA systemA = new SystemA(mediator);
        SystemB systemB = new SystemB(mediator);

        mediator.setSystemA(systemA);
        mediator.setSystemB(systemB);

        systemA.send("Hello SystemB");
        systemB.send("Hello SystemA");
    }
}
