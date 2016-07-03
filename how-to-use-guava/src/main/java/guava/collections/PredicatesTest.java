package guava.collections;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * Created by daijiajia on 16/7/3.
 */
public class PredicatesTest {

    public static void main(String[] args) {
        Predicate<String> notNull = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input != null;
            }
        };

        Predicate<String> notEmpty = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return "" != input;
            }
        };

        System.out.println(Predicates.and(notNull, notEmpty).apply(" "));

//        System.out.println(Predicates.compose(notEmpty, notNull).apply(" "));
    }
}
