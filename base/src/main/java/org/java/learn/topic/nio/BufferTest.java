package org.java.learn.topic.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ClassName: BufferTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 9:09 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class BufferTest {

    public static void main(String[] args) throws IOException {
        // classpath当前目录 D:\opensource\JavaAdvancedTopic\target\classes
        System.out.print(System.getProperties());
        RandomAccessFile file = new RandomAccessFile("data", "rw");
        FileChannel in = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int byteRead = in.read(buffer);
        while (byteRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            byteRead = in.read(buffer);
        }
        file.close();
    }
}
