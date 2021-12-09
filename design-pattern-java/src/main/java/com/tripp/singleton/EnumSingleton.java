package com.tripp.singleton;

// 来自 effective Java 中的写法
// 可以防止反序列化
public enum EnumSingleton {
    enumSingleton;

    public static void main(String[] args) {
        System.out.println(EnumSingleton.enumSingleton);
    }
}
