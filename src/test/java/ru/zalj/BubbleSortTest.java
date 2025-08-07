package ru.zalj;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    private static final Sort sort = new BubbleSort();

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