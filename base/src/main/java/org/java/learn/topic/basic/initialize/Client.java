package org.java.learn.topic.basic.initialize;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-24 16:28 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-24 jdai@ created. <br/>
 */
public class Client {

    /**
     * A static block
     * B static block
     * A non static block
     * A constructor
     * B non static block
     * B constructor
     * B func()
     *
     * @param args
     */
    public static void main(String[] args) {
        ClassA b = new ClassB();
        b.func();
    }
}
