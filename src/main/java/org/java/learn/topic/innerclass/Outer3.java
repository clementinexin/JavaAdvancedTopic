/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:Java-Exercise
 * Package Name:org.java.learn.topic.innerclass
 * File Name:Outer3.java
 * Date:2015年8月24日 上午9:19:54
 * 
 */
package org.java.learn.topic.innerclass;

 /**
 * ClassName: Outer3 <br>
 * Description: TODO <br>
 * Date: 2015年8月24日 上午9:19:54 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

public class Outer3 {
    
    public Outer3() {
        
    }
    
    public void test() {
     // local variable must be defined as final when accessed in a InnerClass as a anonymous
        final int a = 1;
        new Inner3() {

            public void run() {
                System.out.println(a);
            }
            
        };
    }

}
