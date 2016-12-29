
package org.java.learn.topic.jpa;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * ClassName: PersonDAO <br>
 * Description: TODO <br>
 * Date: 2015年9月21日 下午4:53:56 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
 */

public interface PersonDAO extends CrudRepository<Person, String>, JpaSpecificationExecutor<Person> {

}
