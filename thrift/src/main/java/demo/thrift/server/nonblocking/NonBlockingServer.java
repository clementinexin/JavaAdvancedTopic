package demo.thrift.server.nonblocking;

import com.xxx.thrift.Hello;
import com.xxx.thrift.impl.HelloImpl;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by dj on 2017/2/28.
 */
public class NonBlockingServer {

    public static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            Hello.Processor<Hello.Iface> processor = new Hello.Processor<>(new HelloImpl());
            TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(PORT);
            TNonblockingServer.Args tArgs = new TNonblockingServer.Args(serverSocket);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TCompactProtocol.Factory());
            tArgs.transportFactory(new TFramedTransport.Factory());
            TNonblockingServer server = new TNonblockingServer(tArgs);
            System.out.println("TNonblockingServer started ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
