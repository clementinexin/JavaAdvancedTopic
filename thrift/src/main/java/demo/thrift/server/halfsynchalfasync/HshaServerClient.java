package demo.thrift.server.halfsynchalfasync;

import com.xxx.thrift.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dj on 2017/2/28.
 */
public class HshaServerClient {

    public static final String HOST = "0.0.0.0";
    public static final int PORT = 12345;
    public static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        try {
            TAsyncClientManager clientManager = new TAsyncClientManager();
            TNonblockingSocket serverSocket = new TNonblockingSocket(HOST, PORT, TIMEOUT);
            TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
            Hello.AsyncClient client = new Hello.AsyncClient(protocolFactory, clientManager, serverSocket);
            CountDownLatch latch = new CountDownLatch(1);
            AsyncCallback asyncCallback = new AsyncCallback(latch);
            System.out.println("async call before ... ");
            client.sayHello("zhangsan", asyncCallback);
            System.out.println("async call after ...");

            latch.await();
            System.out.println("async call ended");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class AsyncCallback implements AsyncMethodCallback<Hello.AsyncClient.sayHello_call> {

        private CountDownLatch latch;

        public AsyncCallback(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void onComplete(Hello.AsyncClient.sayHello_call sayHello_call) {
            try {
                System.out.println("onComplete returns " + sayHello_call.getResult().toString());
            } catch (TException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }

        @Override
        public void onError(Exception e) {
            System.out.println("onError" + e);
            latch.countDown();
        }
    }
}
