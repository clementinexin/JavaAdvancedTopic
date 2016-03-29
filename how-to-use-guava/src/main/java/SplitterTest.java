import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ClassName: SplitterTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-29 14:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-29 jdai@ created. <br/>
 */
public class SplitterTest {

    @Test
    public void test() {
        Map<String,String> map = Splitter.on("&").omitEmptyStrings().withKeyValueSeparator("=").split("flight=CA1501&dept=PEK");
        assertThat(2,is(map.size()));
        assertThat("CA1501",is(map.get("flight")));
        assertThat("PEK",is(map.get("dept")));
    }
}
