package com.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * 使用JDK动态代理对UserDao产生代理
 */
public class JDKProxy implements InvocationHandler {
    private UserDao userdao;
    public JDKProxy(UserDao userdao)
    {
        this.userdao=userdao;
    }

    /***
     * 产生UserDAO代理方法
      * @return
     */
    public UserDao createProxy()
    {
        UserDao userDaoProxy=(UserDao) Proxy.newProxyInstance(userdao.getClass().getClassLoader(),userdao.getClass().getInterfaces(),this);
        return userDaoProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判断方法名是不是save
        if("save".equals(method.getName()))
        {
            //增强
            System.out.println("权限校验");
            return method.invoke(userdao,args);
        }

        return method.invoke(userdao,args);
    }
}
