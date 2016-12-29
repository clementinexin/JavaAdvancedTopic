package org.java.learn.topic.designpattern.interpreter;

/**
 * ClassName: Context <br/>
 * Description: TODO <br/>
 * Date: 2016-03-22 12:02 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-22 jdai@ created. <br/>
 */
public class Context {

    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public Context(int num1, int num2) {

        this.num1 = num1;
        this.num2 = num2;
    }
}
