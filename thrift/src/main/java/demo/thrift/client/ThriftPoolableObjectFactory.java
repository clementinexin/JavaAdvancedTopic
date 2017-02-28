package demo.thrift.client;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by dj on 2017/2/28.
 */
public class ThriftPoolableObjectFactory implements PoolableObjectFactory<TTransport> {

    private String host;

    private int port;

    private int timeout;

    public ThriftPoolableObjectFactory(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    @Override
    public TTransport makeObject() throws Exception {
        TTransport transport = new TSocket(host, port, timeout);
        transport.open();
        return transport;
    }

    @Override
    public void destroyObject(TTransport obj) throws Exception {
        if (obj.isOpen()) {
            obj.close();
        }
    }

    @Override
    public boolean validateObject(TTransport obj) {
        if (obj instanceof TSocket) {
            TTransport transport = (TSocket) obj;
            if (transport.isOpen()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void activateObject(TTransport obj) throws Exception {

    }

    @Override
    public void passivateObject(TTransport obj) throws Exception {

    }
}
