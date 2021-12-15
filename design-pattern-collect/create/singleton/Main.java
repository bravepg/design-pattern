package create.singleton;

class Singleton {
    private volatile static Singleton instance = null;
    private Singleton() {}

    public static Singleton getSingletonInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    return instance;
                }
            }
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton.getSingletonInstance();
    }
}
