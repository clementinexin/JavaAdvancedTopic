package org.java.learn.topic.designpattern.composite.security;

import java.util.Vector;

/**
 * ClassName: Composit <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 9:52 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Composit implements Component {
    private String name;
    private Vector<Component> components;

    public Composit(String name, Vector<Component> components) {
        this.name = name;
        this.components = components;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println(this.name);
        for (Component component : components) {
            if (component instanceof Composit) {
                this.display();
            } else if (component instanceof Leaf) {
                System.out.print("\t");
                component.display();
            }
        }

    }
}
