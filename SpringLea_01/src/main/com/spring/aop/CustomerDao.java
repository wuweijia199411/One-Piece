package com.spring.aop;

public class CustomerDao {
    public void save()
    {
        System.out.println("保存客户");
    }
    public void delete()
    {
        System.out.println("删除客户");
    }

}
