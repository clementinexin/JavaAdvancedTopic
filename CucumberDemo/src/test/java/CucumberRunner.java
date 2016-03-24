import cucumber.api.CucumberOptions;
import cucumber.api.cli.Main;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * ClassName: CucumberRunner <br/>
 * Description: TODO <br/>
 * Date: 2016-03-24 9:50 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-24 jdai@ created. <br/>
 */
@RunWith(cucumber.api.junit.Cucumber.class)
@CucumberOptions(features = CucumberRunner.featuresDir,plugin = {
        "junit:target/cucumber-report.xml",
        "json:target/cucumber-report.json",
        "pretty",
        "html:target/site/cucumber"},glue = "")
public class CucumberRunner {

    public static final String featuresDir = "src/test/resources";

    public static void main(String[] args) throws IOException {
        Main.run(args,Thread.currentThread().getContextClassLoader());
    }
}
