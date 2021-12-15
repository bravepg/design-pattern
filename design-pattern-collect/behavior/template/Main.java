package behavior.template;

abstract class Beverage {
    final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    void boilWater() {
        System.out.println("把水煮沸");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("倒入杯子");
    }

    abstract void addCondiments();
}

class Coffee extends Beverage {
    @Override
    void brew() {
      System.out.println("冲泡咖啡");
    }
    @Override
    void addCondiments() {
        System.out.println("加糖和牛奶");
    }
}

class Tea extends Beverage {
    @Override
    void brew() {
      System.out.println("浸泡茶叶");
    }
    @Override
    void addCondiments() {
        System.out.println("加柠檬");
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepare();
        Tea tea = new Tea();
        tea.prepare();
    }
}
