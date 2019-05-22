package com.spring.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/***
 * 用户DAO的实现类
 */
@Component("userDao") //相当于<bean id="userDao" class="com.spring.demo.userDAOImpl"/>
public class userDAOImpl implements userDAO {
    @Value("wuw")
    private String username;
    @Override
    public void save() {
        System.out.println("DAO中保存用户的方法执行了。。。"+username);


    }

    public void setUsername(String username) {
        this.username=username;
    }
}
