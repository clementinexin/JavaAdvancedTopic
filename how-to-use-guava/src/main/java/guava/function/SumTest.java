package guava.function;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by daijiajia on 16/8/23.
 */
public class SumTest {

    public static void main(String[] args) {
        List<Integer> arr = Lists.newArrayList(1, 3, 5, 7, 9);
        int sum = Reduce.reduce(arr, new Func<Integer, Integer>() {
            @Override
            public Integer apply(Integer current, Integer origin) {
                return current + origin;
            }
        }, 0);
        System.out.println(sum);
    }
}
