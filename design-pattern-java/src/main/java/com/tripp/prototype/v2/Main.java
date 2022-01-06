package com.tripp.prototype.v2;

// 深拷贝，不会拷贝 Location
class Location implements Cloneable {
    String street;
    String email;

    public Location(String street, String email) {
        this.street = street;
        this.email = email;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
        Person p = (Person) super.clone();
        p.location = (Location) p.location.clone();
        return p;
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Location location = new Location("street1", "email");
        Person p1 = new Person("gao", 25, location);

        Person p2 = (Person) p1.clone();

        p1.location.street = "street2";

        System.out.println(p2.location.street);
    }
}
