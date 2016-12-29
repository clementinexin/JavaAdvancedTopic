package com.study.jooq.common.base;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by daijiajia on 2016/12/15.
 */
public interface ConnPool {

    Connection getConnection() throws SQLException;

    void shutDown();

    void evict(Connection connection);
}
