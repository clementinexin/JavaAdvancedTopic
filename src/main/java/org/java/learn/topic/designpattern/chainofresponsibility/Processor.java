package org.java.learn.topic.designpattern.chainofresponsibility;

/**
 * ClassName: Processor <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:23 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public abstract class Processor {

    private Processor successor;

    public Processor getSuccessor() {
        return successor;
    }

    public void setSuccessor(Processor successor) {
        this.successor = successor;
    }

    public abstract void process();
}
