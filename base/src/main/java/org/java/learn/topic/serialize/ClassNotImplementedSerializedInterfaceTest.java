
package org.java.learn.topic.serialize;

import java.io.*;

/**
 * ClassName: ClassNotImplementedSerializedInterfaceTest <br>
 * Description: Exception in thread "main" java.io.NotSerializableException: com.travelsky.tsb.tlh.TOSFMessage <br>
 * Date: 2015年12月1日 下午2:51:05 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 */

public class ClassNotImplementedSerializedInterfaceTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassNotImplementSerializableInterface message = new ClassNotImplementSerializableInterface();
        message.appData = "Hello";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(os);
        out.writeObject(message.appData);
        byte[] byteArray = os.toByteArray();

        ByteArrayInputStream is = new ByteArrayInputStream(byteArray);

        ObjectInputStream in = new ObjectInputStream(is);
        String result = (String) in.readObject();
        System.out.println(result);
    }

}
