package shell.sample.command;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

/**
 * ClassName: SampleCommand <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 16:38 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
@Component
public class SampleCommand implements CommandMarker {

    @CliCommand(value = "query",help = "query the username")
    public String query(
            @CliOption(key = "id",mandatory = true,help = "input the userid") final String id
    ) {
        return "zhangsan";
    }

    @CliAvailabilityIndicator(value = "query")
    public boolean isQueryAvailable() {
        return true;
    }
}
