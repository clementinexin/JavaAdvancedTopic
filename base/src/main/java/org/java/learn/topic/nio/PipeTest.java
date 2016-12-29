package org.java.learn.topic.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * ClassName: PipeTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 14:22 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class PipeTest {
    public static void main(String[] args) {


        try {
            Pipe pipe = Pipe.open();
            Pipe.SinkChannel sinkChannel = pipe.sink();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            buffer.put("input".getBytes());
            buffer.flip();
            sinkChannel.write(buffer);

            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer out = ByteBuffer.allocate(1024);
            int byteRead = sourceChannel.read(out);
            while (byteRead != -1) {
                out.flip();
                while (out.hasRemaining()) {
                    System.out.print((char) out.get());
                }
                out.clear();
                byteRead = sourceChannel.read(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
