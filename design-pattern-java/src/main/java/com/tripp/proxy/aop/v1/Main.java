package com.tripp.proxy.aop.v1;

import com.tripp.proxy.aop.Tank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");

        Tank tank = (Tank) applicationContext.getBean("tank");
        tank.move();
    }
}
