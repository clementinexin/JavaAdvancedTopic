package shell.sample.command;

import org.springframework.shell.Bootstrap;

import java.io.IOException;

/**
 * ClassName: Bootstrap <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 16:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
public class BootstrapMain {
    public static void main(String[] args) {
        try {
            Bootstrap.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
