package org.java.learn.topic.designpattern.bridge;

/**
 * ClassName: BridgePatternTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 17:09 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public class BridgePatternTest {

    public static void main(String[] args) {
        DriverManager orginal = new OriginalDriverManager();
        orginal.setDriver(new MySQLDriver());
        orginal.connect();
        orginal.setDriver(new OracleDriver());
        orginal.connect();

        DriverManager advanced = new AdvancedDriverManager();
        advanced.setDriver(new MySQLDriver());
        advanced.connect();
        advanced.setDriver(new OracleDriver());
        advanced.connect();
    }
}
