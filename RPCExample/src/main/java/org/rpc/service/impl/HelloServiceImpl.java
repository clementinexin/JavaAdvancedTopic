package org.rpc.service.impl;

import org.rpc.service.HelloService;
import org.rpc.service.annotation.RpcService;

@RpcService(HelloService.class) // 指定远程接口
public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
        return "Hello! " + name;
    }
}