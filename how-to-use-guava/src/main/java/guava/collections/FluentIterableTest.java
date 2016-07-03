package guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by daijiajia on 16/7/3.
 */
public class FluentIterableTest {

    public static void main(String[] args) {
        List<String> ages = Lists.newArrayList("1", "2", "3", "4", "5");
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        };


        Predicate<Integer> odd = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input % 2 == 0;
            }
        };

        Iterable<Integer> result = FluentIterable.from(ages).transform(toInt).filter(odd);
        System.out.println(result);

        List<List<String>> subList = Lists.partition(ages, 2);
        System.out.println(subList);
    }
}
