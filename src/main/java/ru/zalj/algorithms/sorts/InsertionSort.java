package ru.zalj.algorithms.sorts;

public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j]; j--) {
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
            }
        }
        return array;
    }
}
