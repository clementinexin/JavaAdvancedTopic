package guava.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by daijiajia on 16/7/3.
 */
public class OrderingTest {

    public static void main(String[] args) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };


        List<String> list = Lists.newArrayList("A", "B", "C", "D", "E");

        Ordering.from(comparator).reverse(); //反序
        Ordering.from(comparator).nullsFirst(); //null值最小放在前面
        Ordering.from(comparator).compound(comparator); //组合比较器，二次排序
        Collections.sort(list, comparator); //排序
        List<String> topFive = Ordering.from(comparator).greatestOf(list, 5); //前5个
        System.out.println(topFive);
        List<String> bottomThree = Ordering.from(comparator).leastOf(list, 3); //最后3个
        System.out.println(bottomThree);
    }
}
