package org.java.learn.topic.designpattern.observable.org.java.learn.topic.designpattern.observableinjdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by DaiJia on 2015/12/27.
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Being notified " + o);
    }
}
