package guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by daijiajia on 16/7/3.
 */
public class BiMapTest {

    public static void main(String[] args) {
//        BiMap

//        其限制value是唯一的，且通过value可以找到key

        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "Tom");
//        biMap.put("2", "Tom"); //抛出异常
        biMap.forcePut("2", "Tom"); //{2=Tom}，1的值被清了
        BiMap<String, String> inverseMap = biMap.inverse(); //反转key-value

        System.out.println(inverseMap.get("Tom"));
    }
}
