package org.java.learn.topic.designpattern.command;

/**
 * Created by admin on 16/1/31.
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.invoke();

    }
}
