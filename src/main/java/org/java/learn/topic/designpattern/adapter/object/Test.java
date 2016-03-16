package org.java.learn.topic.designpattern.adapter.object;

/**
 * ClassName: Test <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 15:32 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class Test {

    public static void main(String[] args) {
        Source source = new Source();
        Target target = new Target(source);
        target.func1();
        target.func2();
    }
}
