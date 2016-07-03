package guava.collections;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;

/**
 * Created by daijiajia on 16/7/3.
 */
public class MapsTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("A", "B", "C");

        Map<Object, String> result = Maps.uniqueIndex(list, new Function<String, Object>() {
            @Override
            public Object apply(String input) {
                return "_" + input;
            }
        });

        System.out.println(result);

        Map<String, String> out = Maps.asMap(Sets.<String>newHashSet(list), new Function<String, String>() {
            @Override
            public String apply(String input) {
                return "*" + input + "*";
            }
        });
        System.out.println(out);


    }
}
