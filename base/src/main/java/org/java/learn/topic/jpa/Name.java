
package org.java.learn.topic.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * ClassName: Name <br>
 * Description: TODO <br>
 * Date: 2015年9月21日 下午3:46:39 <br>
 * <br>
 *
 * @author JDai(邮箱)
 *         <p>
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br>
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
     * @return the firstName <br>
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * firstName.<br>
     *
     * @param firstName the firstName to set <br>
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * lastName.<br>
     *
     * @return the lastName <br>
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * lastName.<br>
     *
     * @param lastName the lastName to set <br>
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
