package org.java.learn.topic.designpattern.composite.security;

/**
 * ClassName: Leaf <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 9:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class Leaf implements Component {
    @Override
    public void display() {
        System.out.println("leaf");
    }
}
