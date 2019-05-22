package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImp implements UserService{

    @Resource(name = "userDao")
    private userDAO userdao;
    @Override
    public void save() {

        System.out.println("service start");
        userdao.save();
    }
}
