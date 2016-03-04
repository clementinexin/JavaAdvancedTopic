package org.rpc.service.registry;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceRegistry0Test {

    @Test
    public void testInit() throws Exception {
        System.out.println(Thread.currentThread().getName());
        new ServiceRegistry0("127.0.0.1:2181").init();

    }
}