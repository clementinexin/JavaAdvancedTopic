package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: Wheel <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:55 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Wheel {
    String name;

    public Wheel(String name) {
        this.name = name;
    }

    public Wheel() {
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "name='" + name + '\'' +
                '}';
    }
}
