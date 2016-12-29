package org.java.learn.topic.designpattern.memento;

/**
 * ClassName: Test <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator("on");

        Storge storge = new Storge(originator.createMemento());
        System.out.println(originator.getState());

        originator.setState("off");
        System.out.println(originator.getState());

        originator.restoreMemento(storge.getMemento());
        System.out.println(originator.getState());

    }
}
