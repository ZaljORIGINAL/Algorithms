package ru.zalj.algorithms.search;

import java.util.NoSuchElementException;

/**
 * Линейный поиск - Linear Search
 */
public class LinearSearch {

    public int search(final int[] array, final int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        throw new NoSuchElementException("Element '%s' not found".formatted(value));
    }
}
