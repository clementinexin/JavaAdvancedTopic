package org.rpc.service.registry;

import org.I0Itec.zkclient.ZkClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName: ServiceRegistry0 <br/>
 * Description: TODO <br/>
 * Date: 2016-03-04 13:31 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-04 jdai@ created. <br/>
 */
public class ServiceRegistry0 {
    private String zkServer ;

    String ROOT = "/configcenter";
    String SERVICE = "service";

    public ServiceRegistry0(String zkServer) {
        this.zkServer = zkServer;
    }

    public void init() throws UnknownHostException {
        System.out.println(Thread.currentThread().getName());

        ZkClient zkClient = new ZkClient(zkServer);
        boolean rootExists = zkClient.exists(ROOT);
        if (!rootExists) zkClient.createPersistent(ROOT);
        boolean servicePathExists = zkClient.exists(ROOT+"/"+SERVICE);
        if (!servicePathExists) zkClient.createPersistent(ROOT+"/"+SERVICE);
        String ip = InetAddress.getLocalHost().getHostAddress();
        zkClient.createEphemeral(ROOT+"/"+SERVICE+"/"+ip);


    }
}
