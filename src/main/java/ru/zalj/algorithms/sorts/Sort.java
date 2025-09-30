package ru.zalj.algorithms.sorts;

import java.util.Arrays;

public interface Sort {

    default int[] sort(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }
}
