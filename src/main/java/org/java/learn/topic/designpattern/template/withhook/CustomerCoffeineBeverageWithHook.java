package org.java.learn.topic.designpattern.template.withhook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: CustomerCoffeineBeverageWithHook <br/>
 * Description: TODO <br/>
 * Date: 2016-03-17 14:05 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-17 jdai@ created. <br/>
 */
public class CustomerCoffeineBeverageWithHook extends CaffeineBeverageWithHook {
    @Override
    public void brew() {
        System.out.println("brew with hot water");
    }

    @Override
    public void addCondiments() {
        System.out.println("add sugar");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) return true;
        else return false;
    }

    private String getUserInput() {
        System.out.println("would you like coffee with sugar(y/n)?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String answer = null;
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (answer == null) return "no";
        return answer;
    }
}
