/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.httpclient
 * File Name:JSONService.java
 * Date:2015年12月10日 下午3:45:10
 * 
 */
package org.java.learn.topic.httpclient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

 /**
 * ClassName: JSONService <br>
 * Description: TODO <br>
 * Date: 2015年12月10日 下午3:45:10 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
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
