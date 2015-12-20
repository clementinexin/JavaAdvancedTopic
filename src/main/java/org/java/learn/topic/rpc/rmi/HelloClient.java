package org.java.learn.topic.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
//		IHello hello = new HelloImpl();
		IHello hello = (IHello) Naming.lookup("rmi://localhost:10001/RHello");
		System.out.println(hello.sayHi("Hello"));
	}

}
