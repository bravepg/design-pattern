package create.factory.simple;

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

class Factory {
    public static Product createProduct(String param) {
        Product product;
        if (param.equals("A")) {
            product = new ConcreteProductA();
        } else {
            product = new ConcreteProductB();
        }
        return product; 
    }
}

class Main {
    public static void main(String[] args) {
        String param = "A";
        Product product;
        product = Factory.createProduct(param);
        product.use();
    }
}