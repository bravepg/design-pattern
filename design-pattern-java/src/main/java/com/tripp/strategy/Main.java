package com.tripp.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {3, 7, 5, 1};
        Dog[] arr = {new Dog(3), new Dog(5), new Dog(1)};
        WeightComparator weightComparator = new WeightComparator();
//        Sort.sort(arr, weightComparator);
        Sort.sort(arr, ((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        }));
        System.out.println(Arrays.toString(arr));
    }
}
