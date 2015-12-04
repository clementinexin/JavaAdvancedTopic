/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.jpa
 * File Name:Name.java
 * Date:2015年9月21日 下午3:46:39
 * 
 */
package org.java.learn.topic.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

 /**
 * ClassName: Name <br>
 * Description: TODO <br>
 * Date: 2015年9月21日 下午3:46:39 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */

@Embeddable
public class Name implements Serializable {
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "LAST_NAME")
    private String lastName;

    public Name() {
        // TODO Auto-generated constructor stub
    }

    /**
     * firstName.<br>
     *
     * @return  the firstName <br>
     * 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * firstName.<br>
     *
     * @param   firstName    the firstName to set <br>
     * 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * lastName.<br>
     *
     * @return  the lastName <br>
     * 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * lastName.<br>
     *
     * @param   lastName    the lastName to set <br>
     * 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
