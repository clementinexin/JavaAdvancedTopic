package org.java.learn.topic.designpattern.template;

/**
 * ClassName: CaffeineBeverage <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 13:54 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        poureInCup();
        addCondiments();
    }

    public void boilWater() {
        System.out.println("boiling water");
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void poureInCup() {
        System.out.println("pouring into cup");
    }

}
