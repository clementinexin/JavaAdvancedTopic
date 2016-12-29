package org.java.learn.topic.designpattern.singleton;

/**
 * ClassName: Singleton <br/>
 * Description: TODO <br/>
 * Date: 2016-03-09 14:41 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-09 jdai@ created. <br/>
 */
public enum Singleton {

    INSTANCE;

    private String prop1;

    private int prop2;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public int getProp2() {
        return prop2;
    }

    public void setProp2(int prop2) {
        this.prop2 = prop2;
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.getProp1();
    }
}
