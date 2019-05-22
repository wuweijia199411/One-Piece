package com.spring.aop;

public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }
}
