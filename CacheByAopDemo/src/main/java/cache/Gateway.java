package cache;

import org.springframework.stereotype.Component;

/**
 * ClassName: Gateway <br/>
 * Description: TODO <br/>
 * Date: 2016-03-25 15:33 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-25 jdai@ created. <br/>
 */
@Component
public class Gateway<K,V> {

    @Cacheable
    public void put(K k,V v) {

    }

    @Query
    public V get(K k) {
        return null;
    }

}
