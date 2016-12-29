package com.study.jooq.common.context;

import com.study.jooq.common.base.ConnPool;
import com.study.jooq.common.base.HikariConnPoolImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * Created by daijiajia on 2016/12/15.
 */
public enum GlobalContext {

    INSTANCE;

    private final static Logger log = LoggerFactory.getLogger(GlobalContext.class);

    private final ConnPool connPollService;

    GlobalContext() {
        this.connPollService = new HikariConnPoolImpl(); // 构造 mysql 连接池服务
    }

    public ConnPool getConnPoolService() {
        return this.connPollService;
    }

    public void evictConnection(Connection connection) {
        this.connPollService.evict(connection);
    }

    public void contextInitialized() {
        log.info("contextInitialized-----------");
    }

    public void contextDestroyed() {
        log.info("contextDestroyed----------");
        //销毁数据库连接池
        connPollService.shutDown();
    }
}
