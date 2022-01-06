package com.tripp.prototype.v1;

// 浅拷贝，不会拷贝 Location
class Location {
    String street;
    String email;

    public Location(String street, String email) {
        this.street = street;
        this.email = email;
    }
}

// 继承 Cloneable
class Person implements Cloneable {
    String name;
    int age;
    Location location;

    public Person(String name, int age, Location location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Location location = new Location("street", "email");
        Person p1 = new Person("gao", 25, location);

        Person p2 = (Person) p1.clone();

        p1.location.street = "street1";

        System.out.println(p2.location.street);
    }
}
