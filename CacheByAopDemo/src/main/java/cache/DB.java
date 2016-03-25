package cache;

/**
 * ClassName: DB <br/>
 * Description: TODO <br/>
 * Date: 2016-03-25 17:19 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-25 jdai@ created. <br/>
 */
public class DB<K,V> {

    public V load(K k) {
        if (k instanceof Integer) {
            if ( (Integer)k == 1) return (V)"ONE";
            if ( (Integer)k == 2) return (V)"TWO";
        }
        return (V)"none exists";
    }
}
