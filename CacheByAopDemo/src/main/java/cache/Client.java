package cache;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: Client <br/>
 * Description: TODO <br/>
 * Date: 2016-03-25 15:50 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-25 jdai@ created. <br/>
 */
public class Client {

    @Autowired
    Gateway gateway;

    public void test() {
//        gateway.put(1,"ONE");
//        gateway.put(2,"TWO");
        System.out.println(gateway.get(1));
        System.out.println(gateway.get(2));
    }
}
