package demo.thrift.server.simple;

import com.xxx.thrift.Hello;
import com.xxx.thrift.impl.HelloImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by dj on 2017/2/27.
 */
public class TSimpleServerDemo {

    public static final int PORT = 12345;

    public static void main(String[] args) {
        Hello.Processor<Hello.Iface> processor = new Hello.Processor<>(new HelloImpl());

        try {
            TServerSocket serverSocket = new TServerSocket(PORT);
            TServer.Args tArgs = new TServer.Args(serverSocket);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            System.out.println("SimpleServer started ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
