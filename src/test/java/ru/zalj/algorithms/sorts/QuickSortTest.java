package ru.zalj.algorithms.sorts;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class QuickSortTest {
    private static final Sort sort = new QuickSort();

    @Test
    void sort1() {
        int[] array = {10, 2, 5, 4, 7, 6, 1, 3, 9, 8};

        int[] result = sort.sort(array);
        for (int i = 0; i < result.length - 1; i++) {
            assert result[i] <= result[i + 1];
        }
        System.out.println(Arrays.toString(result));
    }
}