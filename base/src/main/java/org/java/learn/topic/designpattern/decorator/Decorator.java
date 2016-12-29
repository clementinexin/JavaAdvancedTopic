package org.java.learn.topic.designpattern.decorator;

/**
 * ClassName: Decorator <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 16:28 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class Decorator implements Originalable {

    private Originalable original;

    public Decorator(Originalable original) {
        this.original = original;
    }

    @Override
    public void func() {
        System.out.println("before decorate");
        original.func();
        System.out.println("after decorate");
    }
}
