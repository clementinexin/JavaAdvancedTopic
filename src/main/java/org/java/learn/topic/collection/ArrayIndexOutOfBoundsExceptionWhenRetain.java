package org.java.learn.topic.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daijiajia on 16/8/1.
 */
public class ArrayIndexOutOfBoundsExceptionWhenRetain {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<String>(1);
        l1.add("f");
        l1.add("e");
//        l1.add(null);
        l1.add("c");
        List<String> l2 = new ArrayList<String>(2);
        l2.add("a");
        l2.add("b");
        l2.add(null);
        l2.add("d");
//        System.out.println(l1.retainAll(l2));
//        System.out.println(l1);

        System.out.println(l2.retainAll(l1));
        System.out.println(l2);


//        System.arraycopy(elementData, r, elementData, w, size - r);
    }
}
