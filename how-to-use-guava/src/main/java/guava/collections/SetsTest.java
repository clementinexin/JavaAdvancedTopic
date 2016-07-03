package guava.collections;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by daijiajia on 16/7/3.
 */
public class SetsTest {

    public static void main(String[] args) {
        Set<String> set1 = Sets.newHashSet("A", "B", "C");
        Set<String> set2 = Sets.newHashSet("C", "D", "E");

        System.out.println(Sets.difference(set1, set2));
        System.out.println(Sets.difference(set2, set1));

        System.out.println(Sets.intersection(set1, set2));

        System.out.println(Sets.union(set1, set2));
    }
}
