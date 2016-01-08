package shell.sample.command;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultHistoryFileNameProvider;
import org.springframework.stereotype.Component;

/**
 * ClassName: SampleHistoryFileNameProvider <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 16:54 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SampleHistoryFileNameProvider extends DefaultHistoryFileNameProvider {
    @Override
    public String getHistoryFileName() {
        return "sample.log";
    }

    @Override
    public String getProviderName() {
        return "Sample Log";
    }
}
