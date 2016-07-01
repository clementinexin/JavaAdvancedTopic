import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.List;
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


        System.out.println(Lists.transform(Lists.newArrayList(Splitter.on(",").omitEmptyStrings().split("2")), new Function<String, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable String input) {
                return Integer.parseInt(input);
            }
        }));

        String ids = "1,2,3";
        List list = Lists.newArrayList();
        System.out.println((Splitter.on(",").omitEmptyStrings().split(ids)).toString());
        Map<String, String> map = Splitter.on("&").omitEmptyStrings().withKeyValueSeparator("=").split("flight=CA1501&dept=PEK");
        assertThat(2, is(map.size()));
        assertThat("CA1501", is(map.get("flight")));
        assertThat("PEK", is(map.get("dept")));
    }
}
