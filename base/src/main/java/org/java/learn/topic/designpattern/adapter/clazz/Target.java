package org.java.learn.topic.designpattern.adapter.clazz;

/**
 * ClassName: Target <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 16:06 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class Target extends Source implements Targetable {
    @Override
    public void func2() {
        System.out.println("target func2");
    }
}
