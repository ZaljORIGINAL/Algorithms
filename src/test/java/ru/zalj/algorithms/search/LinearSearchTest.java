package ru.zalj.algorithms.search;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    void search1() {
        LinearSearch linearSearch = new LinearSearch();
        assertEquals(4, linearSearch.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        assertThrows(NoSuchElementException.class, () -> linearSearch.search(new int[]{}, 5));
    }
}