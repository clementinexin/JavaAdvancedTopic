package org.java.learn.topic.designpattern.mediator;

/**
 * ClassName: MessageServer <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 11:29 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public class MessageServer extends Mediator {

    private SystemA systemA;

    private SystemB systemB;

    public MessageServer() {
    }

    public MessageServer(SystemA systemA, SystemB systemB) {
        this.systemA = systemA;
        this.systemB = systemB;
    }

    public SystemA getSystemA() {
        return systemA;
    }

    public void setSystemA(SystemA systemA) {
        this.systemA = systemA;
    }

    public SystemB getSystemB() {
        return systemB;
    }

    public void setSystemB(SystemB systemB) {
        this.systemB = systemB;
    }

    @Override
    public void send(String msg, Colleague colleague) {
        if (colleague instanceof SystemA) ((SystemA) colleague).func(msg);
        if (colleague instanceof SystemB) ((SystemB) colleague).func(msg);
    }
}
