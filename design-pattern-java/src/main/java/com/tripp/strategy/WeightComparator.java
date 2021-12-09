package com.tripp.strategy;

public class WeightComparator implements Comparator<Dog> {
    @Override
    public int compareTo(Dog o1, Dog o2) {
        return Integer.compare(o1.weight, o2.weight);
    }
}
