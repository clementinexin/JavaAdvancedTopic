package com.study.jooq.common.context;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by daijiajia on 2016/12/15.
 */
public class ScopedContext implements AutoCloseable {

    private Connection connection = null;
    private DSLContext dslContext = null;

    public ScopedContext() {
    }

    public DSLContext getDSLContext() {
        if (dslContext == null) {
            Configuration defaultConfiguration = new DefaultConfiguration().set(getConnection())
                    .set(SQLDialect.MYSQL);

            dslContext = DSL.using(defaultConfiguration);
        }

        return dslContext;
    }

    private Connection getConnection() {
        if (connection == null) {
            connection = createPoolConnection();
        }
        return connection;
    }

    private Connection createPoolConnection() {
        try {
            return GlobalContext.INSTANCE.getConnPoolService().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
        //GlobalContext.INSTANCE.getConnPoolService().shutdown();
    }
}
