package ru.zalj.algorithms.search;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search1() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(8, binarySearch.search(array, 9));
    }

    @Test
    void search2() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 4, 4, 4, 4, 5, 6};
        assertEquals(2, binarySearch.search(array, 4));
    }

    @Disabled // Для поиска элемента с конца
    @Test
    void search3() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 4, 4, 4, 4, 5, 6};
        assertEquals(5, binarySearch.search(array, 4));
    }

    @Disabled // Для получения индекса первого найденного элемента
    @Test
    void search4() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 4, 4, 4, 4, 5, 6};
        assertEquals(3, binarySearch.search(array, 4));
    }
}