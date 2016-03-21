package org.java.learn.topic.designpattern.visitor;

/**
 * ClassName: Visitor <br/>
 * Description: TODO <br/>
 * Date: 2016-03-21 16:58 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-21 jdai@ created. <br/>
 */
public interface Visitor {

    public void visit(ElementA a);

    public void visit(ElementB b);
}
