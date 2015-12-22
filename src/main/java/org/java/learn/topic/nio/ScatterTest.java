package org.java.learn.topic.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ClassName: ScatterTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 9:24 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class ScatterTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("data","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer header = ByteBuffer.allocate(10);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] in = new ByteBuffer[]{header,body};
        long byteRead = channel.read(in);
        while (byteRead != -1) {
            header.flip();
            while (header.hasRemaining()) {
                System.out.print((char)header.get());
            }
            System.out.println();
            body.flip();
            while (body.hasRemaining()) {
                System.out.print((char)body.get());
            }
            header.clear();
            body.clear();
            byteRead = channel.read(in);
        }
        file.close();
    }
}
