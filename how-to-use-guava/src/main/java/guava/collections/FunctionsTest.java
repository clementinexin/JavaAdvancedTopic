package guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by daijiajia on 16/7/3.
 */
public class FunctionsTest {

    public static void main(String[] args) {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("One", 1);
        map.put("Two", 2);
        Function<String, Integer> lookup = Functions.forMap(map, 0);

        System.out.println(lookup.apply("one"));
        System.out.println(lookup.apply("One"));

        Function<String, String> function1 = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return "+" + input;
            }
        };

        Function<String, String> function2 = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input + "-";
            }
        };

        System.out.println(Functions.compose(function1, function2).apply("A"));

        System.out.println(function1.apply(function2.apply("A")));
    }
}
