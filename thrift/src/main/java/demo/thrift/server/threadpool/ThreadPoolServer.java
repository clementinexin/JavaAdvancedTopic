package demo.thrift.server.threadpool;

import com.xxx.thrift.Hello;
import com.xxx.thrift.impl.HelloImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by dj on 2017/2/28.
 */
public class ThreadPoolServer {

    public static final int PORT = 12345;

    public static void main(String[] args) {

        try {
            Hello.Processor<Hello.Iface> processor = new Hello.Processor<>(new HelloImpl());
            TServerSocket serverSocket = new TServerSocket(PORT);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverSocket);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TThreadPoolServer(tArgs);
            System.out.println("ThreadPoolServer started ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
