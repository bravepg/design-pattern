package com.tripp.factory;

abstract class Product1 {
    abstract void use();
}

class ProductA1 extends Product1 {

    @Override
    void use() {
        System.out.println("A");
    }
}

class ProductB1 extends Product1 {

    @Override
    void use() {
        System.out.println("B");
    }
}

public abstract class AbstractFactory {
    abstract Product1 createProduct();
}

class ProductA1Factory extends AbstractFactory {

    @Override
    Product1 createProduct() {
        return new ProductA1();
    }
}

class ProductB1Factory extends AbstractFactory {

    @Override
    Product1 createProduct() {
        return new ProductB1();
    }
}

