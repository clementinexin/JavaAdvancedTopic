package demo

import spock.lang.Specification

/**
 * ClassName: UserBeanSpockTest <br/>
 * Description: TODO <br/>
 * Date: 2016-04-13 13:57 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-13 jdai@ created. <br/>
 */
class UserBeanSpockTest extends Specification {
    def "Func"() {

        given:
        def user = new UserBean()
        expect:
        user.func(input) == output
        where:
        input | output
        "zhangsan" | "Hello zhangsan"
        "lisi"      | "Hello lisi"
    }
}
