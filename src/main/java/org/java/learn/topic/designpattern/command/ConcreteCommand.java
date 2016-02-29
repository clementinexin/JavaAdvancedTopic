package org.java.learn.topic.designpattern.command;

/**
 * Created by admin on 16/1/31.
 */
public class ConcreteCommand implements Command {

    Receiver receiver;

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
