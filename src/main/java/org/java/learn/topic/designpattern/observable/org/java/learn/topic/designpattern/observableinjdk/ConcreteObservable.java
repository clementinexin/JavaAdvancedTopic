package org.java.learn.topic.designpattern.observable.org.java.learn.topic.designpattern.observableinjdk;

import java.util.Observable;

/**
 * Created by DaiJia on 2015/12/27.
 */
public class ConcreteObservable extends Observable {
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "ConcreteObservable{" +
                "name='" + name + '\'' +
                '}';
    }
}
