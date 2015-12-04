/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.dubbo
 * File Name:DemoServiceImpl.java
 * Date:2015年11月26日 上午11:37:37
 * 
 */
package org.java.learn.topic.dubbo;

import java.util.ArrayList;
import java.util.List;

 /**
 * ClassName: DemoServiceImpl <br>
 * Description: TODO <br>
 * Date: 2015年11月26日 上午11:37:37 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

public class DemoServiceImpl implements DemoService{

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public List<User> getUser(String name) {
        List list = new ArrayList();  
        User u1 = new User();  
        u1.setName("jack");  
        u1.setAge(20);  
        u1.setGender('M');  
          
        User u2 = new User();  
        u2.setName("tom");  
        u2.setAge(21);  
        u2.setGender('F');  
          
        User u3 = new User();  
        u3.setName("rose");  
        u3.setAge(19);  
        u3.setGender('F');  
          
        list.add(u1);  
        list.add(u2);  
        list.add(u3);  
        return list;  
    }

}
