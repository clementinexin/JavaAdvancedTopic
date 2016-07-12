package guava.eventbus;

/**
 * Created by daijiajia on 16/7/3.
 */

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * 卖出和购买审计，即订阅者
 */
public class AllTradesAuditor {
    private List<BuyEvent> buyEvents = Lists.newArrayList();
    private List<SellEvent> sellEvents = Lists.newArrayList();

    public AllTradesAuditor(EventBus eventBus) {
        eventBus.register(this);
    }

    /**
     * 订阅卖出事件
     */
    @Subscribe
    public void auditSell(SellEvent sellEvent) {
        sellEvents.add(sellEvent);
        System.out.println("Received TradeSellEvent " + sellEvent);
    }

    /**
     * 订阅购买事件
     */
    @Subscribe
    public void auditBuy(BuyEvent buyEvent) {
        buyEvents.add(buyEvent);
        System.out.println("Received TradeBuyEvent " + buyEvent);
    }
}