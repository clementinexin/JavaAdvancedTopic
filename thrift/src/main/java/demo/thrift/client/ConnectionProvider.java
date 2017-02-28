package demo.thrift.client;

import org.apache.thrift.transport.TSocket;

/**
 * Created by dj on 2017/2/28.
 */
public interface ConnectionProvider {

    public TSocket getConnection();

    public void returnConnection(TSocket socket);


}
