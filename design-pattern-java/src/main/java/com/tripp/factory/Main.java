package com.tripp.factory;

public class Main {
    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("B");
        System.out.println(product);
    }
}
