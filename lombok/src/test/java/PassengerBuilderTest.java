import org.junit.Assert;
import org.junit.Test;
import org.lombok.demo.Address;
import org.lombok.demo.Passenger;

/**
 * Created by daijiajia on 16/5/30.
 */
public class PassengerBuilderTest {

    @Test
    public void test() {
        Passenger passenger = Passenger.builder().name("zhangsan").age(30).gender("Male")
                .address(Address.builder().country("").city("").district("").street("").code("").build())
                .address(Address.builder().country("").city("").district("").street("").code("").build()).build();

        Assert.assertEquals(2, passenger.getAddresses().size());
    }
}
