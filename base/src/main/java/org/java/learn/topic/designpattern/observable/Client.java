package org.java.learn.topic.designpattern.observable;

import java.util.Vector;

/**
 * Created by DaiJia on 2015/12/27.
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("observer1");
        Observer observer2 = new ConcreteObserver("observer1");
        Vector<Observer> elements = new Vector<Observer>();
        elements.add(observer1);
        elements.add(observer2);
        subject.setElements(elements);
        subject.change("CHANGED");

    }
}
