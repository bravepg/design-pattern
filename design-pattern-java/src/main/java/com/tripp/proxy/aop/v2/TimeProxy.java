package com.tripp.proxy.aop.v2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {

    @Before("execution(void com.tripp.proxy.aop.Tank.move())")
    public void before() {
        System.out.println("before");
    }

    @After("execution(void com.tripp.proxy.aop.Tank.move())")
    public void after() {
        System.out.println("after");
    }
}
