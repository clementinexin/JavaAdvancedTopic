package demo.thrift.server.threadedselector;

import com.xxx.thrift.Hello;
import com.xxx.thrift.impl.HelloImpl;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by dj on 2017/2/28.
 */
public class ThreadedSelectorServer {

    public static final int PORT = 12345;

    public static void main(String[] args) {

        try {
            TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(PORT);
            Hello.Processor<Hello.Iface> processor = new Hello.Processor<>(new HelloImpl());
            TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverSocket);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TCompactProtocol.Factory());
            tArgs.transportFactory(new TFramedTransport.Factory());
            TThreadedSelectorServer server = new TThreadedSelectorServer(tArgs);
            System.out.println("TThreadSelectorServer start ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
