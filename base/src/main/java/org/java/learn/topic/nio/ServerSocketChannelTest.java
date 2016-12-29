package org.java.learn.topic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * ClassName: ServerSocketChannelTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 14:39 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class ServerSocketChannelTest {

    public static final int PORT = 8888;

    public static void main(String[] args) {

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            System.out.println("Server start at : " + PORT);
            serverSocketChannel.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();

                if (socketChannel == null) {
                    Thread.sleep(100);

                } else {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.clear();
                    int byteRead = socketChannel.read(buffer);
                    if (socketChannel.isConnected()) {
                        buffer.flip();
                        String in = "";
                        while (buffer.hasRemaining()) {
                            in += (char) buffer.get();
                        }
                        if (in.equals("exit")) {
                            System.exit(0);
                        } else {
                            System.out.println(in);
                        }
                        buffer.clear();
                        byteRead = socketChannel.write(buffer);
                    }
                    socketChannel.close();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
