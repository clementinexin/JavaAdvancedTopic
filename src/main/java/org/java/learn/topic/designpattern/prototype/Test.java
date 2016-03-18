package org.java.learn.topic.designpattern.prototype;

import java.io.IOException;

/**
 * ClassName: Test <br/>
 * Description: TODO <br/>
 * Date: 2016-03-18 10:21 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-18 jdai@ created. <br/>
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype = new Prototype(1,1);
        Prototype prototype1 = (Prototype) prototype.clone(prototype);
        Prototype prototype2 = (Prototype) prototype.deepClone(prototype);
        System.out.println(prototype1.I == prototype2.I);
        System.out.println(prototype1.I == prototype2.i);
        System.out.println(prototype1.i == prototype2.I);
    }
}
