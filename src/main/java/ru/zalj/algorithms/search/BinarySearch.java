package ru.zalj.algorithms.search;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

/**
 * Бинарный поиск - Binary Search
 */
public class BinarySearch {
    public int search(final int[] array, final int value) {
        if (array == null || array.length == 0) {
            throw new InvalidParameterException("Array is null or empty");
        }
        return search(array, value, 0, array.length - 1);
    }

    private int search(final int[] array, final int value, int left, int right) {
        Integer result = null;
        int mid;
        // Поиск первого слева
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == value) {
                result = mid;
                right = mid - 1;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Поиск первого справа
//        while (left <= right) {
//            mid = (left + right) / 2;
//            if (array[mid] == value) {
//                result = mid;
//                left = mid + 1;
//            } else if (array[mid] < value) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }

        if (result != null) {
            return result;
        } else {
            throw new NoSuchElementException("Element '%s' not found".formatted(value));
        }
    }
}
