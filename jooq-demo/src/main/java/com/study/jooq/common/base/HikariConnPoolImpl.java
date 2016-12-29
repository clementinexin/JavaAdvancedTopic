package com.study.jooq.common.base;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by daijiajia on 2016/12/15.
 */
public class HikariConnPoolImpl implements ConnPool {

    private HikariDataSource ds;

    public HikariConnPoolImpl() {
        Properties properties = new Properties();
        properties.setProperty("dataSourceClassName", "com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        properties.setProperty("dataSource.serverName", "127.0.0.1");
        properties.setProperty("dataSource.portNumber", "3306");
        properties.setProperty("dataSource.databaseName", "study");
        properties.setProperty("dataSource.user", "root");
        properties.setProperty("dataSource.password", "321");
        properties.setProperty("dataSource.encoding", "UTF-8");
        properties.setProperty("maximumPoolSize", "100");
        HikariConfig config = new HikariConfig(properties);
        config.setConnectionTimeout(30 * 1000);
        config.setIdleTimeout(60 * 1000);
        config.setMaxLifetime(60 * 1000);
        config.setMinimumIdle(50);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "1000");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    @Override
    public void shutDown() {
        ds.close();
    }

    @Override
    public void evict(Connection connection) {
        ds.evictConnection(connection);
    }
}
