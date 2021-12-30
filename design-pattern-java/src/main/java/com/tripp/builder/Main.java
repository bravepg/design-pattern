package com.tripp.builder;

class Person {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String score;
    private AddressInfo addressInfo;

    private Person() {};

    static class PersonBuilder {
        Person person = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {
            person.id = id;
            person.name = name;
            person.age = age;
            return this;
        }

        public PersonBuilder addressInfo(String street) {
            person.addressInfo = new AddressInfo(street);
            return this;
        }

        public PersonBuilder otherInfo(String sex, String score) {
            person.sex = sex;
            person.score = score;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class AddressInfo {
    String street;

    public AddressInfo(String street) {
        this.street = street;
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder().basicInfo(1, "gao", 25).build();

        System.out.println(person.toString());
    }
}
