package org.java.learn.topic.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ClassName: GatherTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 9:42 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class GatherTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("data","rw");
        FileChannel channel = file.getChannel();

        ByteBuffer header = ByteBuffer.allocate(10);
        header.put("1234567890".getBytes());
        ByteBuffer body = ByteBuffer.allocate(1024);
        body.put("abcde".getBytes());

        header.flip();
        body.flip();
        ByteBuffer[] out = new ByteBuffer[]{header,body};

        channel.write(out);
    }
}
