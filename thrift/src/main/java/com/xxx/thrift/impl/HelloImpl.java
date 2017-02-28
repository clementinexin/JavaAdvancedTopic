package com.xxx.thrift.impl;

import com.xxx.thrift.Hello;
import org.apache.thrift.TException;

/**
 * Created by dj on 2017/2/27.
 */
public class HelloImpl implements Hello.Iface {
    @Override
    public String sayHello(String username) throws TException {
        System.out.println("sayHello has been called");
        return "Hello " + username;
    }
}
