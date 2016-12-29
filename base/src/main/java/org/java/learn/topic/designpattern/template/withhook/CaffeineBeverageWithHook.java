package org.java.learn.topic.designpattern.template.withhook;

/**
 * ClassName: CaffeineBeverageWithHook <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 14:03 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public abstract class CaffeineBeverageWithHook {

    public final void prepareRecipe() {
        boilWater();
        brew();
        poureInCup();
        if (customerWantsCondiments()) addCondiments();
    }

    boolean customerWantsCondiments() {
        return true;
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
