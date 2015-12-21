/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.dubbo
 * File Name:DemoService.java
 * Date:2015年11月26日 上午11:32:05
 * 
 */
package org.java.learn.topic.dubbo;

import java.util.List;

 /**
 * ClassName: DemoService <br>
 * Description: TODO <br>
 * Date: 2015年11月26日 上午11:32:05 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

public interface DemoService {

    String sayHello(String name);
    
    List<User> getUser(String name);
}
