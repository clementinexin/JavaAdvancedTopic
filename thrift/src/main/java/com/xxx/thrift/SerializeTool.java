package com.xxx.thrift;

import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TMemoryBuffer;
import org.apache.thrift.transport.TMemoryInputTransport;

/**
 * Created by dj on 2017/2/27.
 */
public class SerializeTool {

    /**
     * 序列化
     *
     * @param o
     * @return
     */
    public static byte[] serialize(TBase o) {
        TMemoryBuffer memoryBuffer = new TMemoryBuffer(512);
        TBinaryProtocol outProtocol = new TBinaryProtocol(memoryBuffer);
        try {
            o.write(outProtocol);
        } catch (TException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[memoryBuffer.length()];
        System.arraycopy(memoryBuffer.getArray(), 0, b, 0, b.length);
        return b;
    }

    /**
     * 反序列化
     *
     * @param c   原始对象类型
     * @param b
     * @param <O>
     * @return
     */
    public static <O extends TBase> O deserialize(Class<O> c, byte[] b) {
        if (b == null || c == null)
            return null;
        TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport(b);
        TBinaryProtocol inProtocal = new TBinaryProtocol(tMemoryInputTransport);
        try {
            O o = c.newInstance();
            o.read(inProtocal);
            return o;
        } catch (TException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
