package org.java.learn.topic.basic.initialize;

/**
 * ClassName: ClassB <br/>
 * Description: TODO <br/>
 * Date: 2016-03-24 16:27 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-24 jdai@ created. <br/>
 */
public class ClassB extends ClassA {
    static {
        System.out.println("B static block");
    }

    public ClassB() {
        System.out.println("B constructor");
    }

    {
        System.out.println("B non static block");
    }

    @Override
    public void func() {
        System.out.println("B func()");
    }
}
