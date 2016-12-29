package org.java.learn.topic.designpattern.observable;


/**
 * Created by DaiJia on 2015/12/27.
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Being notified " + this.name);
    }

    @Override
    public String toString() {
        return "ConcreteObserver{" +
                "name='" + name + '\'' +
                '}';
    }
}
