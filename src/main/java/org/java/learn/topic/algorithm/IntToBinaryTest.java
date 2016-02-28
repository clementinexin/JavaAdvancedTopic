package org.java.learn.topic.algorithm;

/**
 * ClassName: IntToBinaryTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-22 15:49 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-22 jdai@ created. <br/>
 */
public class IntToBinaryTest {
    public static void main(String[] args) {
        System.out.println(int2Binary(13));
        System.out.printf("%x",845678992357836701L);
    }

    /**
     * why reverse
     * @param i
     * @return
     */
    static String int2Binary(int i) {
        StringBuffer result = new StringBuffer();
        int m = 0,b=0;
        while (true) {
            m = i % 2;
            b = i / 2;

            if (b >= 0) result.append(m);
            if (b == 0) return result.toString();
            i = b;
        }
    }
}
