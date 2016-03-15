package org.java.learn.topic.algorithm;

/**
 * ClassName: IntReverse <br/>
 * Description: TODO <br/>
 * Date: 2016-03-15 16:19 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-15 jdai@ created. <br/>
 */
public class IntReverse {

    public static void main(String[] args) {
//        System.out.println(reverse(1));
        System.out.println(reverse(12));
        System.out.println(reverse(123456));
    }

    static int reverse(int i) {
        int yushu = 0 ;
        int result = 0;
        while (i/10 != 0) {
            yushu = i % 10;
            i = i / 10;
            result = result *10 + yushu;
        }

        return result * 10 + i;
    }

}
