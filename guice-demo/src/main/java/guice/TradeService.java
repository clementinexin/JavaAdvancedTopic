package guice;

import com.google.inject.Inject;

/**
 * ClassName: TradeServiceImpl <br/>
 * Description: TODO <br/>
 * Date: 2016-03-29 13:28 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-29 jdai@ created. <br/>
 */
public class TradeService {

    private Item item;

    private User user;

    @Inject
    public TradeService(Item item, User user) {
        this.item = item;
        this.user = user;
    }

    public void deal() {
        System.out.println(item);
        System.out.println(user);
    }
}
