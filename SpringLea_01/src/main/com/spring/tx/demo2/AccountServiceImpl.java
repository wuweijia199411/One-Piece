package com.spring.tx.demo2;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {
    //注入Dao
    private AccountDao accountDao;

    @Override
    /***
     *
     */
    public void transfer( String from, String to,  Double money) {

        accountDao.outmoney(from,money);
        //int d=1/0;
        accountDao.inmoney(to,money);


    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
