package org.java.learn.topic.rpc.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello, Serializable {

    protected HelloImpl() throws RemoteException {
        super();
    }

    public String sayHi(String greeting) {
        return greeting + " world! ";
    }

}
