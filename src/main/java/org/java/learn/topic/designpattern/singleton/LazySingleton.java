package org.java.learn.topic.designpattern.singleton;

/**
 * ClassName: LazySingleton <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 18:23 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class LazySingleton {

    private static LazySingleton INSTANCE = null;

    private LazySingleton() {
    }

    synchronized public LazySingleton getInstance() {

        if (INSTANCE == null) {
            synchronized (this) {
                if (INSTANCE == null) INSTANCE = new LazySingleton();
            }
        }
        return INSTANCE;
    }
}
