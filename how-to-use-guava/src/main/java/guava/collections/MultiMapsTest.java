package guava.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;

/**
 * Created by daijiajia on 16/7/3.
 */
public class MultiMapsTest {
    public static void main(String[] args) {
//        Multimaps类

//                一个key对应多个value

//        ArrayListMultiMap

        ArrayListMultimap<String, String> arrmultiMap = ArrayListMultimap.create();
        arrmultiMap.put("Bar", "1");
        arrmultiMap.put("Bar", "2");
        arrmultiMap.put("Bar", "3");
        arrmultiMap.put("Bar", "3");
        arrmultiMap.put("Bar", "3");
        System.out.println(arrmultiMap); //{Bar=[1, 2, 3, 3, 3]}，相同的value会重复，value内部是一个List
//        HashMultiMap

        HashMultimap<String, String> hashmultiMap = HashMultimap.create();
        hashmultiMap.put("Bar", "1");
        hashmultiMap.put("Bar", "2");
        hashmultiMap.put("Bar", "3");
        hashmultiMap.put("Bar", "3");
        hashmultiMap.put("Bar", "3");
        System.out.println(hashmultiMap); //{Bar=[1, 2, 3]}，相同的value不会重复，value内部是一个Set

    }
}
