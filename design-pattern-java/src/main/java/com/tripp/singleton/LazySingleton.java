package com.tripp.singleton;

public class LazySingleton {
    // volatile 用于 JIT 编译优化
    public static volatile LazySingleton lazySingleton = null;
    private int age;

    public static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
                return lazySingleton;
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        System.out.println(LazySingleton.getLazySingleton());
    }
}
