package com.spring.tx.demo3;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT ,propagation = Propagation.REQUIRED) //隔离级别和传播行为
public class AccountServiceImpl implements AccountService {
    //注入Dao
    private AccountDao accountDao;

    @Override
    /***
     *
     */
    public void transfer( String from, String to,  Double money) {

        accountDao.outmoney(from,money);
        int d=1/0;
        accountDao.inmoney(to,money);


    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
