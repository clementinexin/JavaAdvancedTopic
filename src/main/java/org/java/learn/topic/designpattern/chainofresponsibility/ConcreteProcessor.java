package org.java.learn.topic.designpattern.chainofresponsibility;

/**
 * ClassName: ConcreteProcessor <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:25 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class ConcreteProcessor extends Processor {
    String name;

    public ConcreteProcessor(String name) {
        this.name = name;
    }

    @Override
    public void process() {
        System.out.println(name + " processed");
        if (getSuccessor() != null) getSuccessor().process();
    }
}
