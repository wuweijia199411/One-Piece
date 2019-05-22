package com.spring.tx.demo1;

public interface AccountDao {
    public void outmoney(String from,Double money);
    public void inmoney(String in,Double money);
}
