package com.spring.jdbc.demo1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;

public class JdbcDemo1 {

    //jdbc摸板使用类似与Dbutils
    public void demo1()
    {
        //创建连接池
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring4");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //创建JDBC摸板
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account values (null,?,?)","wu",10000d);
    }

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public void demo2()
    {
        jdbcTemplate.update("update account set name = ? ,money= ? where id=?","qqq",2000,1);
    }

}
