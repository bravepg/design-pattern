package com.tripp.proxy.aop.v1;

public class TimeProxy {
    public void before() {
        System.out.println("start");
    }

    public void after() {
        System.out.println("end");
    }

}
