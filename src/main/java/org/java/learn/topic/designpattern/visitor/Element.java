package main.java.org.java.learn.topic.designpattern.visitor;

/**
 * ClassName: Element <br/>
 * Description: TODO <br/>
 * Date: 2016-03-21 16:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-21 jdai@ created. <br/>
 */
public interface Element {
    public void accept(Visitor visitor);

    public void func();
}
