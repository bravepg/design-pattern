package com.tripp.factory;

abstract class Product {
    abstract void use();
}

class ProductA extends Product {

    @Override
    void use() {
        System.out.println("A");
    }
}

class ProductB extends Product {

    @Override
    void use() {
        System.out.println("B");
    }
}

public class SimpleFactory {
    public static Product createProduct(String param) {
        if (param.equals("A")) {
            return new ProductA();
        }
        return new ProductB();
    }
}
