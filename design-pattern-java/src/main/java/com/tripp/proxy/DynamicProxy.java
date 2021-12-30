package com.tripp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements Movable {

    @Override
    public void move() {
        System.out.println("DynamicProxy");
    }

    public static void main(String[] args) {
        Movable movable = (Movable) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{Movable.class}, new LogHandler(new DynamicProxy()));

        movable.move();
    }
}

class LogHandler implements InvocationHandler {
    DynamicProxy dynamicProxy;

    public LogHandler(DynamicProxy dynamicProxy) {
        this.dynamicProxy = dynamicProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "start");
        Object object = method.invoke(dynamicProxy, args);
        System.out.println(method.getName() + "end");
        return object;
    }
}
