package org.java.learn.topic.designpattern.interpreter;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 12:04 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context(1,10);
        Expression add = new Add();
        Expression minus = new Minus();
        System.out.println(add.interpret(context));
        System.out.println(minus.interpret(context));
    }
}
