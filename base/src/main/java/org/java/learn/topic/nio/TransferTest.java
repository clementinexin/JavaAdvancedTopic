package org.java.learn.topic.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ClassName: TransferTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 9:56 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class TransferTest {
    public static void main(String[] args) throws IOException {
//        transferFrom();
        transferTo();
    }

    public static void transferFrom() throws IOException {
        RandomAccessFile fromFlie = new RandomAccessFile("from", "r");
        FileChannel fromChannel = fromFlie.getChannel();
        ByteBuffer in = ByteBuffer.allocate(1024);

        RandomAccessFile toFile = new RandomAccessFile("to", "rw");
        FileChannel toChannel = toFile.getChannel();
        ByteBuffer out = ByteBuffer.allocate(1024);

        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel, position, count);
        int byteRead = toChannel.read(out);
        while (byteRead != -1) {
            out.flip();
            while (out.hasRemaining()) {
                System.out.print((char) out.get());
            }
            out.clear();
            byteRead = toChannel.read(out);
        }
    }

    public static void transferTo() throws IOException {
        RandomAccessFile fromFlie = new RandomAccessFile("from", "r");
        FileChannel fromChannel = fromFlie.getChannel();
        ByteBuffer in = ByteBuffer.allocate(1024);

        RandomAccessFile toFile = new RandomAccessFile("to", "rw");
        FileChannel toChannel = toFile.getChannel();
        ByteBuffer out = ByteBuffer.allocate(1024);

        long position = 0;
        long count = fromChannel.size();
        fromChannel.transferTo(position, count, toChannel);

        int byteRead = toChannel.read(out);
        out.flip();
        while (byteRead != -1) {

            while (out.hasRemaining()) {
                System.out.print((char) out.get());
            }
            out.clear();
            byteRead = toChannel.read(out);
        }
    }
}
