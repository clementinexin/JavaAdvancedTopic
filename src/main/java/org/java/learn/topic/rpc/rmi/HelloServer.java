package org.java.learn.topic.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		IHello hello = new HelloImpl();
		LocateRegistry.createRegistry(10001);
		Naming.bind("rmi://localhost:10001/RHello", hello);
		System.out.println("启动远程RMI注册服务");
		
	}

}
