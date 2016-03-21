package main.java.org.java.learn.topic.designpattern.visitor;

/**
 * ClassName: ElementB <br/>
 * Description: TODO <br/>
 * Date: 2016-03-21 17:01 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-21 jdai@ created. <br/>
 */
public class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void func() {
        System.out.println("ElementB visited");
    }
}
