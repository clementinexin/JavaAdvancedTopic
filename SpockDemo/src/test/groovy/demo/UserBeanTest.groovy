package demo
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

    void "UseAndWith"() {
        def user = new UserBean
                (
                        addresses
                                [
                                        new Address(country: "CN", city: "PEK", district: "SY", street: "RH", subdistrict: "ZJ", zipCode: "100100"),
                                        new Address(country: "CN", city: "WUH", district: "QS", street: "GY", subdistrict: "QY", zipCode: "420000",
                                                contacts:
                                                        [
                                                                new Contact(telephone: "13123456789", cellphone: "01012345678")
                                                        ]
                                        )

                                        ]
                )

        /*
        assert user.addresses.size().is(2)
        assert user.addresses[1].contacts.size().is(1)

        use(demo.spock.AssertUtil) {
            user.addresses.eachWithIndex { Address address, idx ->
                address.with {
                    assert 国家() == 'CN'
                }
            }
            assert user.addresses.collect({ return it.city }) == ['PEK', "WUH"]
        }*/


    }

}
