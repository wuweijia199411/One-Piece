package com.spring.aopfight;

import org.aspectj.lang.ProceedingJoinPoint;

/***
 * 切面类
 */
public class MyAspectXML {
    /***
     * 前置通知
     */
    public void checkPri()
    {
        System.out.println("权限校验---------------");
    }
    /***
     * 后置通知
     */
    public void writeLog(Object result)
    {
        System.out.println("日志执行=================="+result);
    }

    /***
     * 性能监控
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知===========");
        Object obj=joinPoint.proceed();
        System.out.println("环绕后通知===========");
        return obj;
    }

    /**
     * 异常抛出通知
     */
    public void afterThrowing(Throwable ex)
    {
        System.out.println("异常抛出通知============="+ex.getMessage());
    }
    /***
     * 最终通知
     */
    public void after()
    {
        System.out.println("最终通知");
    }



}
