package guice;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class GuiceDemoModuleTest {

    Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new GuiceDemoModule());
    }

    @Test
    public void test_commonservice_in_runtime() {
        CommonService commonService = injector.getInstance(CommonService.class);
        assertThat(commonService,is(instanceOf(CommonService.class)));
    }


    @Test
    public void test_userservice_must_be_singleton() {

        UserService service1 = injector.getInstance(UserService.class);
        UserService service2 = injector.getInstance(UserService.class);

        assertEquals(service1,service2);
    }

    @Test
    public void test_itemservice_has_two_implemention() {
        List<ItemService> itemServices = Lists.newArrayList(injector.getInstance(new Key<Set<ItemService>>() {}));
        assertEquals(2,itemServices.size());
    }

    //guice.Item@8909f18
    //guice.User@79ca92b9
    //
    @Test
    public void test_tradeservice_with_inject() {
        Injector injector1 = Guice.createInjector();
        TradeService tradeService = injector1.getInstance(TradeService.class);

        tradeService.deal();
    }

    @After
    public void tearDown() throws Exception {

    }
}