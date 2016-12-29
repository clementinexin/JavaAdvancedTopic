package org.java.learn.topic.designpattern.bridge;

/**
 * ClassName: DriverManager <br/>
 * Description: TODO <br/>
 * Date: 2016-03-16 17:05 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-16 jdai@ created. <br/>
 */
public abstract class DriverManager implements Driver {

    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void connect() {
        driver.connect();
    }
}
