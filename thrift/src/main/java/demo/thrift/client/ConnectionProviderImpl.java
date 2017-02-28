package demo.thrift.client;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by dj on 2017/2/28.
 */
public class ConnectionProviderImpl implements ConnectionProvider, InitializingBean, DisposableBean {

    /**
     * 服务的IP地址
     */
    private String serviceIP;
    /**
     * 服务的端口
     */
    private int servicePort;
    /**
     * 连接超时配置
     */
    private int conTimeOut;
    /**
     * 可以从缓存池中分配对象的最大数量
     */
    private int maxActive = GenericObjectPool.DEFAULT_MAX_ACTIVE;
    /**
     * 缓存池中最大空闲对象数量
     */
    private int maxIdle = GenericObjectPool.DEFAULT_MAX_IDLE;
    /**
     * 缓存池中最小空闲对象数量
     */
    private int minIdle = GenericObjectPool.DEFAULT_MIN_IDLE;
    /**
     * 阻塞的最大数量
     */
    private long maxWait = GenericObjectPool.DEFAULT_MAX_WAIT;

    /**
     * 从缓存池中分配对象，是否执行PoolableObjectFactory.validateObject方法
     */
    private boolean testOnBorrow = GenericObjectPool.DEFAULT_TEST_ON_BORROW;
    private boolean testOnReturn = GenericObjectPool.DEFAULT_TEST_ON_RETURN;
    private boolean testWhileIdle = GenericObjectPool.DEFAULT_TEST_WHILE_IDLE;

    /**
     * 对象缓存池
     */
    private ObjectPool<TTransport> objectPool = null;

    @Override
    public TSocket getConnection() {
        try {
            TSocket socket = (TSocket) objectPool.borrowObject();
            return socket;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void returnConnection(TSocket socket) {
        try {
            objectPool.returnObject(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        objectPool = new GenericObjectPool<>();

        ((GenericObjectPool<TTransport>) objectPool).setMaxActive(maxActive);
        ((GenericObjectPool<TTransport>) objectPool).setMaxIdle(maxIdle);
        ((GenericObjectPool<TTransport>) objectPool).setMaxWait(maxWait);
        ((GenericObjectPool<TTransport>) objectPool).setMinIdle(minIdle);
        ((GenericObjectPool<TTransport>) objectPool).setTestOnBorrow(testOnBorrow);
        ((GenericObjectPool<TTransport>) objectPool).setTestOnReturn(testOnReturn);
        ((GenericObjectPool<TTransport>) objectPool).setTestWhileIdle(testWhileIdle);

        ThriftPoolableObjectFactory factory = new ThriftPoolableObjectFactory(serviceIP, servicePort, conTimeOut);
        ((GenericObjectPool<TTransport>) objectPool).setFactory(factory);
    }
}
