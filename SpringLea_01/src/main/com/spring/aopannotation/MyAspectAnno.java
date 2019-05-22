package com.spring.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnno {
    @Before(value = "MyAspectAnno.pointcut2()")
    public void before()
    {
        System.out.println("前置增强==============");
    }

    //后置
    @AfterReturning(value = "execution(* com.spring.aopannotation.OrderDao.delete(..))",returning = "result")
    public void afterReturning(Object result)
    {
        System.out.println("后置增强=========="+result);
    }

    //环绕
    @Around(value = "MyAspectAnno.pointcut3()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强==========");
        Object obj=joinPoint.proceed();
        System.out.println("环绕后增强==========");
        return obj;
    }

    //异常抛出通知
    @AfterThrowing( value = "execution(* com.spring.aopannotation.OrderDao.search(..))",throwing = "ex")
    public void afterThrowing(Throwable ex)
    {
        System.out.println("异常抛出==========="+ex.getMessage());
    }

    //最终通知
    @After(value = "MyAspectAnno.pointcut1()")
    public void after()
    {
        System.out.println("最终通知======");
    }

    //切入点注解
    @Pointcut(value = "execution(* com.spring.aopannotation.OrderDao.search(..))")
    private void pointcut1()
    {}
    @Pointcut(value = "execution(* com.spring.aopannotation.OrderDao.save(..))")
    private void pointcut2()
    {}
    @Pointcut(value = "execution(* com.spring.aopannotation.OrderDao.update(..))")
    private void pointcut3()
    {}



}
