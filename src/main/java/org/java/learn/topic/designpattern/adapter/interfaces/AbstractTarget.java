package org.java.learn.topic.designpattern.adapter.interfaces;

/**
 * ClassName: AbstractTarget <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 16:17 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public abstract class AbstractTarget implements Targetable {
    @Override
    public void func1() {
        System.out.println("source func1");
    }

    @Override
    public abstract void func2();
}
