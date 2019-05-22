package com.spring.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/***
 * cglib动态代理
 */
public class CglibProxy implements MethodInterceptor {
    private CustomerDao customerDao;
    public CglibProxy(CustomerDao cd)
    {
        customerDao=cd;
    }

    /***
     * 使用
     */
    public CustomerDao createProxy()
    {
        //创建cglib的核心类对象
        Enhancer enhancer=new Enhancer();
        //设置父类
        enhancer.setSuperclass(customerDao.getClass());
        //设置回调（类似于InvocationHandler对象）
        enhancer.setCallback(this);
        //创建代理对象
        CustomerDao proxy=(CustomerDao) enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("save".equals(method.getName()))
        {
            System.out.println("权限校验----");
            return methodProxy.invokeSuper(o,objects);
        }
        return methodProxy.invokeSuper(o,objects);
    }
}
