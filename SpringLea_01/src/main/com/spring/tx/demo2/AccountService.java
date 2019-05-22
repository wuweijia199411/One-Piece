package com.spring.tx.demo2;

/****
 * 转账接口
 */
public interface AccountService {

    public void transfer(String from, String to, Double money);

}
