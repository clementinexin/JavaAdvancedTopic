package org.java.learn.topic.designpattern.chainofresponsibility;

/**
 * ClassName: Test <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:27 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Test {

    public static void main(String[] args) {
        Processor processor1 = new ConcreteProcessor("processor1");
        Processor processor2 = new ConcreteProcessor("processor2");
        processor1.setSuccessor(processor2);

        processor1.process();
    }
}
