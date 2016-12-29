package org.java.learn.topic.designpattern.visitor;

/**
 * ClassName: VisitorA <br/>
 * Description: TODO <br/>
 * Date: 2016-03-21 17:01 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-21 jdai@ created. <br/>
 */
public class VisitorImpl implements Visitor {
    @Override
    public void visit(ElementA a) {
        a.func();
    }

    @Override
    public void visit(ElementB b) {
        b.func();
    }
}
