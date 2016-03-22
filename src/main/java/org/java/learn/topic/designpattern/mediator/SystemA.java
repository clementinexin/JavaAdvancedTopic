package org.java.learn.topic.designpattern.mediator;

/**
 * ClassName: SystemA <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 11:28 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public class SystemA extends Colleague {


    public SystemA(Mediator mediator) {
        super(mediator);
    }

    public void send(String msg) {
        this.mediator.send(msg, this);
    }

    public void func(String msg) {
        System.out.println(msg);
        System.out.println("SystemA send a message to SystemB");
    }
}
