package org.java.learn.topic.designpattern.factory.abstracts;

/**
 * ClassName: Motor <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 17:55 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Motor {
    String name;

    public Motor(String name) {
        this.name = name;
    }

    public Motor() {
    }

    @Override
    public String toString() {
        return "Motor{" +
                "name='" + name + '\'' +
                '}';
    }
}
