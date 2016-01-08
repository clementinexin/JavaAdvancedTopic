package shell.sample.command;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

/**
 * ClassName: SampleBannerProvider <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 16:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SampleBannerProvider extends DefaultBannerProvider {
    @Override
    public String getBanner() {
        StringBuffer buf = new StringBuffer();
        buf.append("=======================================" + OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *"+ OsUtils.LINE_SEPARATOR);
        buf.append("*            HelloWorld               *" +OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *"+ OsUtils.LINE_SEPARATOR);
        buf.append("=======================================" + OsUtils.LINE_SEPARATOR);
        buf.append("Version:" + this.getVersion());
        return buf.toString();
    }

    @Override
    public String getVersion() {
        return "1.1.1";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Spring Shell Demo";
    }

    @Override
    public String getProviderName() {
        return "Someone";
    }
}
