package org.java.learn.topic.spring.core;


/**
 * ClassName: TestObject <br/>
 * Description: TODO <br/>
 * Date: 2016-01-21 9:23 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-21 jdai@ created. <br/>
 */
public class UserFactory {

    public static User setUserByName(String name) {
        return new User(name);
    }

    public User getUserByName(String name) {
        return new User(name);
    }
}
