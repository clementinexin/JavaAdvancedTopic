package org.java.learn.topic.designpattern.bridge;

/**
 * ClassName: MySQLDriver <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 17:04 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class MySQLDriver implements Driver {
    @Override
    public void connect() {
        System.out.println("MySQL connect");
    }
}
