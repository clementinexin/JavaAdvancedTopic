package org.java.learn.topic.designpattern.mediator;

/**
 * ClassName: Mediator <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 11:25 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public abstract class Mediator {

    public abstract void send(String msg,Colleague colleague);
}
