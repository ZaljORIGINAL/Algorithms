package ru.zalj.algorithms.sorts;

public class ShakerSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (array[i-1] > array[i]) {
                    int temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
            left++;
        }

        return array;
    }
}
