import java.util.Arrays;
import java.util.List;

/**
 * Created by daijiajia on 16/6/28.
 */
public class SubListTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> sub = list.subList(1, list.size());
        System.out.println(sub);
        sub.set(0, "d");
//        sub.add("d");
        System.out.println(sub);
        System.out.println(list);
    }
}
