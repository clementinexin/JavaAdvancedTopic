package guava.function;

import java.util.Iterator;

/**
 * Created by daijiajia on 16/8/23.
 */
public class Reduce<F, T> {

    private Reduce() {
    }

    public static <F, T> T reduce(Iterable<F> iterable, Func<F, T> func, T origin) {
        for (Iterator<F> iterator = iterable.iterator(); iterator.hasNext(); ) {
            origin = func.apply(iterator.next(), origin);
        }
        return origin;
    }
}
