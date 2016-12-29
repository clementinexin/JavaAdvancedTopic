
package org.java.learn.topic.innerclass;

/**
 * ClassName: Outer2 <br>
 * Description: TODO <br>
 * Date: 2015年8月24日 上午9:11:16 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 */

public class Outer2 {
    public Outer2() {

    }

    public void test() {
        // local variable must be defined as final when accessed in a InnerClass as a local
        final int a = 1;
        class Inner2 {
            public Inner2() {

            }

            public void run() {
                System.out.println(a);
            }
        }
    }

}
