package com.tripp.singleton;

// 这种方式存在一个弊端
// 在 HungerSingleton 类加载进内存的时候
// 会立即被实例化
public class HungerSingleton {
    private static final HungerSingleton hungerSingleton = new HungerSingleton();

    // 用于去除警告 instantiation of utility class 'HungerSingleton'
    public int age;

    private HungerSingleton() {}

    public static HungerSingleton getHungerSingleton() {
        return hungerSingleton;
    }

    public static void main(String[] args) {
        System.out.println(HungerSingleton.getHungerSingleton());
    }
}
