package ru.zalj;

import java.util.Arrays;

public interface Sort {

    default int[] sort(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }
}
