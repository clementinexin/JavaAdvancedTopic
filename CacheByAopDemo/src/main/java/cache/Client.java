package cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:cache.xml")
public class Client {

    @Autowired
    Gateway gateway;

    @Test
    public void test() {
//        gateway.put(1,"ONE");
//        gateway.put(2,"TWO");
        System.out.println(gateway.get(1));
        System.out.println(gateway.get(2));
    }
}
