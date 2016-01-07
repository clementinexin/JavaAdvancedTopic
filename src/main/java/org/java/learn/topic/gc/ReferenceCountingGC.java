package org.java.learn.topic.gc;

import java.sql.Ref;

/**
 * ClassName: ReferenceCountingGC <br/>
 * Description: TODO <br/>
 * Date: 2016-01-07 15:38 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-07 jdai@ created. <br/>
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024*1024;

    private byte[] size = new byte[1 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }
}
