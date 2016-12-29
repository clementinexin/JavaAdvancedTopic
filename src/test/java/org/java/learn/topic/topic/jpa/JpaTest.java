package org.java.learn.topic.jpa;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 /**
 * ClassName: JpaTest <br>
 * Description: TODO <br>
 * Date: 2015年9月21日 下午4:26:03 <br>
 * <br>
 * 
 * @author JDai(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:jpa-domain.xml"})
public class JpaTest {
    
    @Autowired
    PersonDAO dao;
    
    @Test
    public void TestEmbed() {
        Person person = new Person();
        person.setAddress("Test Address");
        Name name = new Name();
        name.setFirstName("Test First Name");
        name.setLastName("Test Last Name");
        person.setName(name);
        
        dao.save(person);
    }

}
