package org.java.learn.topic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * ClassName: SelectorTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 17:21 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class SelectorTest {
    public static final int PORT = 8888;
    static ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        System.out.println("Server listening at port : " + PORT);
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int n = selector.select();
            if (n == 0) {
                continue;
            }
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    System.out.println("accept client : " + sc);
                    acceptClient(sc);
                }
                if (key.isReadable()) {
                    readData(key);
                }
                it.remove();
            }
        }
    }

    protected static void readData(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        buffer.flip();
        int count = socketChannel.read(buffer);
        while (count > 0) {
            while (buffer.hasRemaining()) {
//                socketChannel.write(buffer);
                System.out.print((char) buffer.get());
            }

            buffer.clear();
            count = socketChannel.read(buffer);
            if (count < 0) {
                socketChannel.close();
            }
        }
    }

    private static void acceptClient(SocketChannel channel) throws IOException {
        buffer.clear();
        buffer.put("you have already connected server!".getBytes());
        buffer.flip();

        channel.write(buffer);
    }

}
