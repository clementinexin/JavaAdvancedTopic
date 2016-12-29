
package org.java.learn.topic.regex;

/**
 * ClassName: RegexTest <br>
 * Description: TODO <br>
 * Date: 2015年12月1日 下午4:10:29 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 */

public class RegexTest {

    public static void main(String[] args) {
        String in = "08.1\\SEAT_CA\\RCT_CA_01_SYN\\3\\342956\\1E\\A\\13780\\0\\CN\\0\\RES\\7\\resdata";
        System.out.println(in.replace('\\', '-'));

    }

}
