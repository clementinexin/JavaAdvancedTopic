package demo.thrift.client;

import org.apache.thrift.transport.TSocket;

import javax.annotation.Resource;

/**
 * Created by dj on 2017/2/28.
 */
public class ConnectionManager {

    @Resource
    ConnectionProvider connectionProvider;

    ThreadLocal<TSocket> local = new ThreadLocal<>();

    public TSocket getConnection() {
        TSocket socket = null;
        try {
            socket = connectionProvider.getConnection();
            local.set(socket);
            return local.get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionProvider.returnConnection(socket);
        }
        return socket;
    }
}
