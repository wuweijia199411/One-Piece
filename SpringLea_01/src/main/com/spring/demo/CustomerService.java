package com.spring.demo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("customerService")
public class CustomerService {

    @PostConstruct //相当于init_method
    public void init()
    {
        System.out.println("service初始化了");
    }
    public void save()
    {
        System.out.println("service方法执行了");
    }
    @PreDestroy //相当于destroy_method
    public void destroy()
    {
        System.out.println("service销毁了了");
    }
}
