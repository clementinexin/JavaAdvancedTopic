package org.java.learn.topic.designpattern.memento;

/**
 * ClassName: Storge <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 15:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Storge {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Storge(Memento memento) {

        this.memento = memento;
    }
}
