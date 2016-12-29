package org.java.learn.topic.rpc.rmi;

import java.rmi.Remote;

public interface IHello extends Remote {

    public String sayHi(String greeting);
}
