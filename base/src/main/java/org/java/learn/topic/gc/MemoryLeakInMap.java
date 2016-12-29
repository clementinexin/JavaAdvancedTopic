package org.java.learn.topic.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MemoryLeakInMap <br/>
 * Description: TODO <br/>
 * Date: 2016-01-08 8:52 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-08 jdai@ created. <br/>
 */
public class MemoryLeakInMap {

    static class MemoryLeaker {
        Integer id;

        /*
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MemoryLeaker)) return false;

            MemoryLeaker that = (MemoryLeaker) o;

            if (id != null ? !id.equals(that.id) : that.id != null) return false;

            return true;
        }
        */

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        public MemoryLeaker(Integer id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Map<MemoryLeaker, Integer> map = new HashMap<MemoryLeaker, Integer>();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                map.put(new MemoryLeaker(i), 0);
            }
        }
    }
}
