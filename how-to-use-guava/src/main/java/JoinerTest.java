import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * ClassName: JoinerTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-29 14:59 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-29 jdai@ created. <br/>
 */
public class JoinerTest {

    public static void main(String[] args) {
        args = new String[]{"a", null, "b", "c"};
        System.out.println(Joiner.on("|").skipNulls().join(args));

        System.out.println(Joiner.on("&").withKeyValueSeparator("=").join(ImmutableMap.of("flight", "CA1501", "dept", "PEK")));

        Map<String, String> map = Maps.newHashMap();
        map.put("one", "1");
        map.put("two", "2");


    }
}
