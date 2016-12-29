package org.java.learn.topic.designpattern.adapter.object;

/**
 * ClassName: Target <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 15:27 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class Target implements Targetable {
    private Source source;

    public Target(Source source) {
        this.source = source;
    }

    @Override
    public void func1() {
        source.func1();
    }

    @Override
    public void func2() {
        System.out.println("Target func2");
    }
}
