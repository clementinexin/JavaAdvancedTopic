import cucumber.api.PendingException;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

/**
 * ClassName: hello <br/>
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
    private String greeting;

    @假如("^安装正常")
    public void 安装正常() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @当("^执行hello$")
    public void 执行hello(String arg) throws Throwable {
        greeting = arg;
        System.out.println("获取参数 " + arg);
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @那么("^得到world$")
    public void 得到world(String arg) throws Throwable {
        if ("hello".equals(greeting)) System.out.println(greeting + " " + arg);
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

}
