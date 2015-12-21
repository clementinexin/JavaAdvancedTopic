/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.Class
 * File Name:ClassLoaderTree.java
 * Date:2015年12月14日 上午10:19:22
 * 
 */
package org.java.learn.topic.Class;

 /**
 * ClassName: ClassLoaderTree <br>
 * sun.misc.Launcher$AppClassLoader@37b90b39 <br>
 * sun.misc.Launcher$ExtClassLoader@558fe7c3 <br>
 * null <br>
 * Date: 2015年12月14日 上午10:19:22 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */
public class ClassLoaderTree {

    public void test() {
        ClassLoader loader = this.getClass().getClassLoader();
        System.out.println(loader);
        while (null != loader.getParent()) {
            System.out.println(loader.getParent());
            loader = loader.getParent();
        }
        System.out.println(loader.getParent());
    }
    public static void main(String[] args) {
        new ClassLoaderTree().test();
        
    }

}
