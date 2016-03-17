package org.java.learn.topic.designpattern.composit.transparent;

import org.java.learn.topic.designpattern.composite.security.*;

import java.util.Vector;

/**
 * ClassName: Composit <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 10:13 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Composit extends Component {

    private Vector<Component> components;

    public Composit(String name) {
        super(name);
    }

    public Vector<Component> getComponents() {
        return components;
    }

    public void setComponents(Vector<Component> components) {
        this.components = components;
    }

    @Override
    public void display() {
        System.out.println(this.getName());
        for (Component component : components) {
            if (component instanceof Composit) {
                this.display();
            } else if (component instanceof Leaf) {
                System.out.print("\t");
                component.display();
            }
        }
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }
}
