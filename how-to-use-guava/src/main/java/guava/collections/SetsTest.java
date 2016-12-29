package guava.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
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

        List l1 = Lists.newArrayList("A", "B", "F");
        List l2 = Lists.newArrayList("C", "E", "F");

        System.out.println(l1.retainAll(l2));
        System.out.println(l1);
        System.out.println(Sets.intersection(Sets.newHashSet(l1), Sets.newHashSet(l2)));
        Lists.newArrayList(set2).retainAll(Lists.newArrayList(set1));
        System.out.println(set2);
        System.out.println(Sets.union(set1, set2));
    }
}
