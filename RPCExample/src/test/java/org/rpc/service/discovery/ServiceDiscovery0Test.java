package org.rpc.service.discovery;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceDiscovery0Test {

    @Test
    public void testInit() throws Exception {
        new ServiceDiscovery0("127.0.0.1:2181").init();

    }
}