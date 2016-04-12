package demo;

import java.util.List;

/**
 * ClassName: demo.UserBean <br/>
 * Description: TODO <br/>
 * Date: 2016-04-12 15:17 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-04-12 jdai@ created. <br/>
 */
public class UserBean {

    List<Address> addresses;

    String func(String name) {
        return "Hello " + name;
    }
}
