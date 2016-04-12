package demo

import org.junit.Test

/**
 * ClassName: demo.UserBeanTest <br/>
 * Description: TODO <br/>
 * Date: 2016-04-12 15:19 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-12 jdai@ created. <br/>
 */
class UserBeanTest {

    @Test
    void "UseAndWith"() {
        def user = new UserBean();
            user.addresses = [new Address(country:"CN",city:"PEK",district:"SY",street:"RH",subdistrict:"ZJ",zipCode:"100100"),
                              new Address(country:"CN",city:"WUH",district:"QS",street:"GY",subdistrict:"QY",zipCode:"420000")]
        assert user.addresses.size().is(2)

        use(AssertUtil) {
            user.addresses.eachWithIndex{ Address address, idx ->

                    address.with {
                        assert 国家() == 'CN'
                    }

            assert address.city.collect({return it}) == ['PEK',"WUH"]
            }
        }
    }

    @Test
    void "Func"() {

        given:
            UserBean user = new UserBean()
        expect:
            user.func(input) == output
        where:
        input | output
        "zhangsan" | "Hello zhangsan"
        "lisi"      | "Hello lisi"
    }
}
