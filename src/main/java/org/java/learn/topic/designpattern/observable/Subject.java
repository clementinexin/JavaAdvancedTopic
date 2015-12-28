package org.java.learn.topic.designpattern.observable;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by DaiJia on 2015/12/27.
 */
public class Subject {

    private Vector elements = new Vector();

    public void setElements(Vector elements) {
        this.elements = elements;
    }

    public void add(Observer observer) {
        elements.add(observer);
        System.out.println("add a observer : " + observer);
    }

    public void delete(Observer observer) {
        elements.removeElement(observer);
        System.out.println("remove a observer : " + observer);
    }

    public void notifyObservers() {
        Enumeration<Observer> enumeration = elements.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println("Before update");
            enumeration.nextElement().update();
            System.out.println("After update");
        }
    }

    public Enumeration observers() {
        return ((Vector<Observer>)elements.clone()).elements();
    }
}
