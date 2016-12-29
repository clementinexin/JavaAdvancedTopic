package org.java.learn.topic.designpattern.singleton;

/**
 * ClassName: EagerSingleton <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 18:22 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class EagerSingleton {

    private static EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public EagerSingleton getInstance() {
        return INSTANCE;
    }
}
