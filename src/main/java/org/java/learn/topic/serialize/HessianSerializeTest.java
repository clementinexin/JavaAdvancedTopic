
package org.java.learn.topic.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianOutput;

 /**
 * ClassName: HessianSerializeTest <br>
 * Description: Exception in thread "main" java.lang.IllegalStateException: Serialized class com.travelsky.tsb.tlh.TOSFMessage must implement java.io.Serializable <br>
 * Date: 2015年12月1日 下午2:49:07 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

public class HessianSerializeTest {

    public static void main(String[] args) throws IOException {
        ClassNotImplementSerializableInterface message = new ClassNotImplementSerializableInterface();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(message);
        
    }

}
