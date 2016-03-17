package org.java.learn.topic.designpattern.composite.security;

import java.util.Vector;

/**
 * ClassName: CompositTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 9:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class CompositTest {

    public static void main(String[] args) {
        Composit composit = new Composit("composit",new Vector<Component>());
        composit.add(new Leaf());
        composit.add(new Leaf());
//        composit.add(new Composit("composit",new Vector<Component>()));
        composit.display();
    }
}
