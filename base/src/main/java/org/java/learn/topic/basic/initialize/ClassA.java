package org.java.learn.topic.basic.initialize;

/**
 * ClassName: ClassA <br/>
 * Description: TODO <br/>
 * Date: 2016-03-24 16:25 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-24 jdai@ created. <br/>
 */
public class ClassA {
    static {
        System.out.println("A static block");
    }

    public ClassA() {
        System.out.println("A constructor");
    }

    {
        System.out.println("A non static block");
    }

    public void func() {
        System.out.println("A func()");
    }
}
