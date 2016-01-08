package shell.sample.command;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

/**
 * ClassName: SamplePromptProvider <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 16:56 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SamplePromptProvider extends DefaultPromptProvider {
    @Override
    public String getPrompt() {
        return "Sample-Shell>";
    }

    @Override
    public String getProviderName() {
        return "Sample Prompt";
    }
}
