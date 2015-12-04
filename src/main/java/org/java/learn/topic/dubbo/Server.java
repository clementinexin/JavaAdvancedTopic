/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.dubbo
 * File Name:Server.java
 * Date:2015年11月26日 上午11:44:14
 * 
 */
package org.java.learn.topic.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

 /**
 * ClassName: Server <br>
 * Description: TODO <br>
 * Date: 2015年11月26日 上午11:44:14 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

public class Server {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"Service.xml"});
        context.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
