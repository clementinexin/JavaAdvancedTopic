package org.java.learn.topic.spring.core;

/**
 * ClassName: User <br/>
 * Description: TODO <br/>
 * Date: 2016-01-21 11:56 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-21 jdai@ created. <br/>
 */
public class User {
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
