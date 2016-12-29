package guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.stream.Collectors;

/**
 * ClassName: guava.collections.SplitterTest <br/>
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

    public void test() {


        System.out.println(Lists.transform(Lists.newArrayList(Splitter.on(",").omitEmptyStrings().split("1,2,3")), new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        }));

        System.out.println(Lists.newArrayList(Splitter.on(",").omitEmptyStrings().split("1,2,3"))
                .stream()
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList()));

        /*
        String ids = "1,2,3";
        List list = Lists.newArrayList();
        System.out.println((Splitter.on(",").omitEmptyStrings().split(ids)).toString());
        Map<String, String> map = Splitter.on("&").omitEmptyStrings().withKeyValueSeparator("=").split("flight=CA1501&dept=PEK");
        assertThat(2, is(map.size()));
        assertThat("CA1501", is(map.get("flight")));
        assertThat("PEK", is(map.get("dept")));
        */

    }


}
