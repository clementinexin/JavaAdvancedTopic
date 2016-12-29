package org.java.learn.topic.designpattern.command;

/**
 * Created by admin on 16/1/31.
 */
public class Invoker {
    Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Invoker(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }
}
