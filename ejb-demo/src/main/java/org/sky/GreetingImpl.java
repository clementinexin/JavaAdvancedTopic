package org.sky;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * ClassName: GreetingImpl <br/>
 * Description: TODO <br/>
 * Date: 2016-03-29 17:04 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-29 jdai@ created. <br/>
 */
@Stateless
@Remote
public class GreetingImpl implements Greeting {
    @Override
    public String greet(String name) {
        System.out.println("Hello " + name);
        return "Hello " + name;
    }
}
