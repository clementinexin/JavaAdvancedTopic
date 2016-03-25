package org.java.learn.topic.basic;

/**
 * ClassName: SwitchWithoutBreak <br/>
 * Description: TODO <br/>
 * Date: 2016-03-24 16:15 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-24 jdai@ created. <br/>
 */
public class SwitchWithoutBreak {

    public static void main(String[] args) {

        int condition = 3;
        switch (condition) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            default:
                System.out.println("default");
        }
    }
}
