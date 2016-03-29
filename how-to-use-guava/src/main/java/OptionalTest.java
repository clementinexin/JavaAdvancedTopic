import com.google.common.base.Optional;

/**
 * ClassName: OptionalTest <br/>
 * Description: TODO <br/>
 * Date: 2016-03-29 15:21 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-29 jdai@ created. <br/>
 */
public class OptionalTest {

    public static void main(String[] args) {
        args = new String[] {"a",null,"b","c"};
        for (String arg : args) {
            System.out.println(Optional.fromNullable(arg).or(""));
        }
    }
}
