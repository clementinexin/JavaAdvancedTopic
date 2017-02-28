package demo.thrift.server.simple;

import com.xxx.thrift.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by dj on 2017/2/27.
 */
public class SimpleServerClient {

    public static final String HOST = "0.0.0.0";
    public static final int PORT = 12345;
    public static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket(HOST, PORT, TIMEOUT));
        TProtocol protocol = new TCompactProtocol(transport);
        Hello.Client client = new Hello.Client(protocol);

        try {
            transport.open();
            String res = client.sayHello("zhangsan");
            System.out.println("call back from server : " + res);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
