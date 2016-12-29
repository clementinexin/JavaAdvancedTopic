
package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * ClassName: ClientTest <br>
 * Description: TODO <br>
 * Date: 2015年12月7日 下午3:33:45 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 */

public class ClientTest {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        // TODO Auto-generated method stub

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet("www.baidu.com");

        HttpResponse response = client.execute(get);

        HttpEntity entity = response.getEntity();
        System.out.println(new String(EntityUtils.toByteArray(entity), "utf8"));
    }

}
