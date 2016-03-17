package org.java.learn.topic.designpattern.composit.transparent;

import java.util.Vector;

/**
 * ClassName: CompositTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 10:16 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class CompositTest {

    public static void main(String[] args) {
        Composit composit = new Composit("composit");
        composit.setComponents(new Vector<Component>());
        composit.add(new Leaf("leaf1"));
        composit.add(new Leaf("leaf2"));
        composit.display();
    }
}
