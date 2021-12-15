package com.tripp.factory;

abstract class Weapon {
    abstract void attack();
}

abstract class Food {
    abstract void eat();
}

public abstract class AbstractFactory {
    abstract Weapon createWeapon();
    abstract Food createFood();
}

class WeaponA extends Weapon {

    @Override
    void attack() {
        System.out.println("attack A");
    }
}

class FoodA extends Food {

    @Override
    void eat() {
        System.out.println("eat A");
    }
}

class AbstractFactoryA extends AbstractFactory {

    @Override
    Weapon createWeapon() {
        return new WeaponA();
    }

    @Override
    Food createFood() {
        return new FoodA();
    }
}
