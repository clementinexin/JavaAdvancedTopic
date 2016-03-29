package guice;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.google.inject.matcher.Matchers.any;

/**
 * ClassName: guice.guice <br/>
 * Description: TODO <br/>
 * Date: 2016-03-29 13:20 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-29 jdai@ created. <br/>
 */
public class GuiceDemoModule extends AbstractModule {

    private CommonService commonService = new CommonServiceImpl();

    public static final Logger logger = LoggerFactory.getLogger(GuiceDemoModule.class);

    @Override
    protected void configure() {
        Binder binder = binder();
        if (logger.isDebugEnabled()) {
            binder.bindInterceptor(any(),any(),new MyMethodInterceptor());
        }

        binder.bind(UserService.class).to(UserServiceImpl.class).in(Scopes.SINGLETON);

        binder.bind(LogisticService.class).in(Scopes.SINGLETON);

        final Multibinder<ItemService> itemServiceBinder = Multibinder.newSetBinder(binder,ItemService.class);
        itemServiceBinder.addBinding().to(ItemServiceImplByMySQL.class);
        itemServiceBinder.addBinding().to(ItemServiceImplByOracle.class);

        binder.bind(CommonService.class).toInstance(commonService);

//        binder.bind(TradeService.class).to(TradeService.class).in(Scopes.SINGLETON);

    }
}
