package structure.facade;

class A {
    public void doWork() {
        System.out.println("A doWork");
    }
}

class B {
    public void doWork() {
        System.out.println("B doWork");
    }
}

class C {
    public void doWork() {
        System.out.println("B doWork");
    }
}

class Facade {
    public void doWork() {
        new A().doWork();
        new B().doWork();
        new C().doWork();
    }
}

public class Main {
    public static void main(String[] args) {
        // new A().doWork();
        // new B().doWork();
        // new C().doWork();

        // 通过外观者调用
        new Facade().doWork();
    }
}