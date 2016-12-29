package org.java.learn.topic.designpattern.decorator;

/**
 * ClassName: Original <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 16:26 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class Original implements Originalable {
    @Override
    public void func() {
        System.out.println("original func");
    }
}
