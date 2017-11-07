package com.joe.hw.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
    /**
     * 实现数据库连接的工具类
     * 连接池，dbcp连接池
     */
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/nowJDBC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setInitialSize(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setMaxActive(10);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
