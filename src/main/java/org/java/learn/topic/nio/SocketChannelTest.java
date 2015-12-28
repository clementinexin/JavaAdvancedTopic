package org.java.learn.topic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * ClassName: SocketChannelTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 14:45 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class SocketChannelTest {
    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost",8888));
            socketChannel.configureBlocking(false);
            while (!socketChannel.finishConnect()) {
                Thread.sleep(1000);
            }
            ByteBuffer out = ByteBuffer.allocate(1024);
            out.clear();
            out.put("input".getBytes());
            out.flip();
            System.out.println(socketChannel.write(out));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
