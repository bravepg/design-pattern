package com.tripp.strategy;

public class Dog implements Comparable<Dog>{
    public int weight;

    public Dog(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog o) {
        return Integer.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                '}';
    }
}
