package guava.function;

/**
 * Created by daijiajia on 16/8/23.
 */
public interface Func<F, T> {

    T apply(F current, T origin);
}
