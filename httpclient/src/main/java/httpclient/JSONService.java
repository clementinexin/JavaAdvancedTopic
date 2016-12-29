
package httpclient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * ClassName: JSONService <br>
 * Description: TODO <br>
 * Date: 2015年12月10日 下午3:45:10 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 */
@Path("/json/product")
public class JSONService {

    @GET
    @Path("/get")
    @Produces("application/json")
    public Product getProduct() {
        Product product = new Product();
        product.setName("iPad 3");
        product.setQty("999");

        return product;

    }

    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createProductInJSON(Product product) {

        String result = "Product created : " + product;
        return Response.status(201).entity(result).build();

    }


}
