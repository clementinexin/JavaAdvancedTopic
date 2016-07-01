package demo;

import cucumber.api.java.zh_cn.假设;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

import static org.junit.Assert.assertEquals;

/**
 * ClassName: demo.hello <br/>
 * Description: TODO <br/>
 * Date: 2016-03-24 10:11 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-24 jdai@ created. <br/>
 */
public class hello {

    Adder adder;


    @假设("^有一个正数(\\d+)$")
    public void 有一个正数(int arg1) throws Throwable {
        adder = new Adder();
        adder.a = arg1;

    }

    @当("^加上一个正数(\\d+)$")
    public void 加上一个正数(int arg1) throws Throwable {
        adder.add(arg1);
    }

    @那么("^得到一个正数(\\d+)$")
    public void 得到一个正数(int arg1) throws Throwable {
        assertEquals(adder.c, arg1);
    }
}
