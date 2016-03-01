package org.jgroups.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

/**
 *
 * <pre>
 * 节点.
 * </pre>
 *
 */
public class Node extends ReceiverAdapter {

    private final static Logger LOG = Logger.getLogger(Node.class);

    /**
     * 配置文件.
     */
    private static final String CONFIG_XML = "network-tcp.xml";

    /**
     * 集群名称.
     */
    private static final String CLUSTER_NAME = "FF";

    /**
     * 节点通道.
     */
    private JChannel channel = null;

    /**
     * 以此作为节点间初始化的同步数据.
     */
    private Map<String, String> cacheData = new HashMap<String, String>();

    private ReentrantLock lock = new ReentrantLock();

    public Node() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(CONFIG_XML);
        try {
            channel = new JChannel(is);
            channel.setReceiver(this);
            channel.connect(CLUSTER_NAME);
            channel.getState(null,50000);
        } catch (Exception e) {
            LOG.error("启动节点异常!", e);
            // 最好是自定义RuntimeException!
            throw new RuntimeException("启动节点异常!", e);
        }
    }

    /**
     *
     * <pre>
     * 发送消息给目标地址.
     * </pre>
     *
     * @param dest
     *            为空表示发给所有节点.
     * @param textMsg
     *            消息.
     */
    public void sendMsg(Address dest, Object textMsg) {
        Message msg = new Message(dest, null, textMsg);
        try {
            channel.send(msg);
        } catch (Exception e) {
            LOG.error("消息发送失败!", e);
            // 应自定异常,最好是自定义Exception类型!
            throw new RuntimeException("消息发送失败!", e);
        }
    }

    @Override
    public void getState(OutputStream output) throws Exception {
        //cacheData过大可能会造成节点的状态同步时间过长.
        lock.lock();
        try {
            Util.objectToStream(cacheData, new DataOutputStream(output));
        }catch(Exception e){
            throw e;
        }finally{
            lock.unlock();
        }
    }

    @Override
    public void receive(Message msg) {
        //当前节点不接收自己发送到通道当中的消息.
        if (msg.getSrc().equals(channel.getAddress())) {
            return;
        }
        LOG.info(msg.getObject());
    }

    @Override
    public void setState(InputStream input) throws Exception {
        lock.lock();
        try {
            @SuppressWarnings("unchecked")
            Map<String, String> cacheData = (Map<String, String>) Util.objectFromStream(new DataInputStream(input));
            this.cacheData.putAll(cacheData);
        } catch (Exception e) {
            LOG.error("从主节点同步状态到当前节点发生异常!", e);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void viewAccepted(View view) {
        LOG.info("当前成员[" + this.channel.getAddressAsString() + "]");
        LOG.info(view.getCreator());
        LOG.info(view.getMembers());
        LOG.info("当前节点数据:" + cacheData);
    }
    /**
     *
     * <pre>
     * 提供一个简单的初始化数据的方法.
     * </pre>
     *
     */
    public void addData(String key,String val){
        if(key!=null&&!key.isEmpty()){
            cacheData.put(key, val);
        }
    }
}