package com.spring.tx.demo2;

public interface AccountDao {
    public void outmoney(String from, Double money);
    public void inmoney(String in, Double money);
}
