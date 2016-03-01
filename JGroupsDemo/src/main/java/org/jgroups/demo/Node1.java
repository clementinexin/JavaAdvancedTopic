package org.jgroups.demo;

/**
 * ClassName: Node1 <br/>
 * Description: TODO <br/>
 * Date: 2016-03-01 9:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-01 jdai@ created. <br/>
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * <pre>
 * tcp模式下:
 * 如果是同一台机器测试,请注意在
 * TCPPING 元素下修改 initial_hosts的配置端口:
 * 例如:"${jgroups.tcpping.initial_hosts:192.168.19.100[7800],192.168.19.100[7801]}
 * 如果是多台机器测试,请注意在
 * TCPPING 元素下修改 initial_hosts的ip,端口随意:
 * 例如:"${jgroups.tcpping.initial_hosts:192.168.19.100[7800],192.168.19.178[7800]}
 *
 * udp模式下:
 * 同一台机器的不同端口(端口是动态的)可通信.
 * 不同机器之间的ip多播可能会受到一些因素限制而造成节点之间无法彼此发现.
 * </pre>
 *
 */
public class Node1 {

    public static void main(String[] args) {
        Node node = new Node();
        node.addData("hello", "world");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 使用控制台发送消息给Node2.
        Scanner scanner = new Scanner(System.in);
        while(true){
            String text = scanner.next();
            if("exit".equals(text)){
                break;
            }
            node.sendMsg(null,"hello "+text+",node2!");
        }

    }

}
