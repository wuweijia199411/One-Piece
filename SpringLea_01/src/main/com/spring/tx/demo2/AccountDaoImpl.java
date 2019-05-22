package com.spring.tx.demo2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void outmoney(String from, Double money) {

        this.getJdbcTemplate().update("update account set money = money-? where name =?",money,from);
    }

    @Override
    public void inmoney(String in, Double money) {
        this.getJdbcTemplate().update("update account set money=money+? where name =?",money,in);

    }
}
