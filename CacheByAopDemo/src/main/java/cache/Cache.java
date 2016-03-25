package cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ClassName: Cache <br/>
 * Description: TODO <br/>
 * Date: 2016-03-25 15:12 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-25 jdai@ created. <br/>
 */
@Component
public class Cache<K,V> {

    @Autowired
    DB db;

    static ReadWriteLock rw = new ReentrantReadWriteLock();

    private Map<K,V> map = new HashMap<K, V>();

    public void put(K k,V v) {
        rw.writeLock().lock();
        map.put(k,v);
        rw.writeLock().unlock();
    }

    public V get(K k) {

        rw.readLock().lock();
        V v = map.get(k);
        if (v == null) {
            rw.readLock().unlock();
            rw.writeLock().lock();
            if (map.get(k) == null) {
                v = (V) db.load(k);
                put(k,v);
            }
            rw.writeLock().unlock();
            return v;
        } else {
            rw.readLock().unlock();
            return v;
        }
    }



}
