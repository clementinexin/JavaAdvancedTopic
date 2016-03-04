package org.rpc.service.discovery;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * ClassName: ServiceDiscovery0 <br/>
 * Description: TODO <br/>
 * Date: 2016-03-04 13:44 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-04 jdai@ created. <br/>
 */
public class ServiceDiscovery0 {
    private String zkServer;

    private List<String> addressList;

    String ROOT = "/configcenter";
    String SERVICE = "service";

    public ServiceDiscovery0(String zkServer) {
        this.zkServer = zkServer;
    }

    public void init() {
        ZkClient zkClient = new ZkClient(zkServer);
        if (!zkClient.exists(ROOT)) throw new RuntimeException("ROOT does not exists!");
        if (!zkClient.exists(ROOT+"/"+SERVICE)) throw new RuntimeException("SERVICE does not exists!");
        addressList = zkClient.getChildren(ROOT+"/"+SERVICE);
        zkClient.subscribeChildChanges(ROOT + "/" + SERVICE, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                addressList = currentChilds;
            }
        });

        System.out.println(addressList);

    }
}
