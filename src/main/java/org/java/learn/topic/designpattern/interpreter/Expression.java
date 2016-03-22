package org.java.learn.topic.designpattern.interpreter;

/**
 * ClassName: Expression <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 12:02 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public interface Expression {

    public int interpret(Context context);
}
