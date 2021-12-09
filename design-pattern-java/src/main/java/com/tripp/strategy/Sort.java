package com.tripp.strategy;

public class Sort {
    public static<T> void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compareTo(arr[j], arr[min]) == -1) {
                    min = j;
                }
            }

            if (min != i) {
                T temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
