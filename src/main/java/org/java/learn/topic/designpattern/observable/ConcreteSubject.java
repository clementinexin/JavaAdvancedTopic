package org.java.learn.topic.designpattern.observable;

/**
 * Created by DaiJia on 2015/12/27.
 */
public class ConcreteSubject extends Subject{
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public void change(String state) {
        this.state = state;
        this.notifyObservers();
    }
}
