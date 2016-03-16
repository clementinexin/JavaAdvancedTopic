package org.java.learn.topic.designpattern.bridge;

/**
 * ClassName: OracleDriver <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 17:05 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class OracleDriver implements Driver {
    @Override
    public void connect() {
        System.out.println("Oracle connect");
    }
}
