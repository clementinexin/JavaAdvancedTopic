package org.java.learn.topic.designpattern.composit.transparent;

/**
 * ClassName: Component <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 10:10 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public abstract class Component {
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();

    public abstract void add(Component component);

    public abstract void  remove(Component component);
}
