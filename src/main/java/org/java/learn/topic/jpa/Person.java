/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:exercise
 * Package Name:org.java.learn.topic.jpa
 * File Name:Person.java
 * Date:2015年9月21日 下午3:54:26
 * 
 */
package org.java.learn.topic.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

 /**
 * ClassName: Person <br>
 * Description: TODO <br>
 * Date: 2015年9月21日 下午3:54:26 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */
@Entity
@Table(name = "TEST_PERSON")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private Long id;
    
    @Embedded
    private Name name;
    
    @Column(name = "ADDRESS")
    private String address;
    
    public Person() {
        // TODO Auto-generated constructor stub
    }

    /**
     * name.<br>
     *
     * @return  the name <br>
     * 
     */
    public Name getName() {
        return name;
    }

    /**
     * name.<br>
     *
     * @param   name    the name to set <br>
     * 
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * address.<br>
     *
     * @return  the address <br>
     * 
     */
    public String getAddress() {
        return address;
    }

    /**
     * address.<br>
     *
     * @param   address    the address to set <br>
     * 
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
