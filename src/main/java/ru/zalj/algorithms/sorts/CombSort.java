package ru.zalj.algorithms.sorts;

public class CombSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        double factor = 1.247;
        double step = array.length - 1;

        while (step > 1) {
            for (int i = 0; i + step < array.length; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            step /= factor;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
