package org.java.learn.topic.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: HeapOOM <br/>
 * Description: TODO <br/>
 * Date: 2016-01-07 14:01 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-07 jdai@ created. <br/>
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
