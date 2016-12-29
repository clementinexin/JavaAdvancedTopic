package org.java.learn.topic.designpattern.interpreter;

/**
 * ClassName: Minus <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 12:04 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public class Minus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}
