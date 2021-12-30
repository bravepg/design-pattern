package structure.proxy;

interface Movable {
    void move();
}

class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("tank move");
    }
}

class TimeProxy implements Movable {
    Movable movable;

    public TimeProxy(Movable movable) {
        this.movable = movable;
    }


    @Override
    public void move() {
        System.out.println("time");
        movable.move();
    }
}

class LoggerProxy implements Movable {
    Movable movable;

    public LoggerProxy(Movable movable) {
        this.movable = movable;
    }


    @Override
    public void move() {
        System.out.println("logger");
        movable.move();
    }
}

// 代理跟装饰者模式很类似
public class Main {

    public static void main(String[] args) {
        Movable movable = new LoggerProxy(new TimeProxy(new Tank()));

        movable.move();
    }
}
