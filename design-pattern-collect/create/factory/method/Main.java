package create.factory.method;

abstract class Product {
    public void use() {}
}

class ConcreteProductA extends Product {
    public void use() {
        System.out.println("ConcreteProductA");
    }
}

class ConcreteProductB extends Product {
    public void use() {
        System.out.println("ConcreteProductB");
    }
}

abstract class Factory {
    public abstract Product createProduct();
}

class ConcreteFactoryA extends Factory {
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

public class Main {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA();
        Product product = factory.createProduct();
        product.use();
    }
}