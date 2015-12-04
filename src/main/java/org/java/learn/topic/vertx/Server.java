/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.vertx
 * File Name:Server.java
 * Date:2015年11月25日 下午4:21:55
 * 
 */
package org.java.learn.topic.vertx;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

 /**
 * ClassName: Server <br>
 * Description: TODO <br>
 * Date: 2015年11月25日 下午4:21:55 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

public class Server extends Verticle {

    
        public void start() {
            vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
                public void handle(HttpServerRequest req) {
                    String file = req.path().equals("/") ? "index.html" : req.path();
                    req.response().sendFile("webroot/" + file);
                }
            }).listen(8080);
        }
    

}
