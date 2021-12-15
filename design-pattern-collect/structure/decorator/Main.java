package structure.decorator;

abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
class Mocha extends CondimentDecorator {
    Beverage beverage;
    
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}

class Whip extends CondimentDecorator {
    Beverage beverage;
    
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "Whip";
    }

    @Override
    public double cost() {
        return 0.09 + beverage.cost();
    }
}



public class Main {
    public static void main(String[] args) {
        Espresso espresso = new Espresso();
        Mocha mocha = new Mocha(espresso);
        Whip whip = new Whip(mocha);

        System.out.println(whip.cost());
    }
}
