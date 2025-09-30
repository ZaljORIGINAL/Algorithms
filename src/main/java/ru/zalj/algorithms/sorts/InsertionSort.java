package ru.zalj.algorithms.sorts;

/**
 * Сортировка вставками - Insertion Sort
 */
public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        // Сортируемый массив условно разделяется на 2 части ОТСОРТИРОВАННЫЙ и ЭЛЕМЕНТЫ ДЛЯ СОРТИРОВКИ
        // Считается, что первый элемент это уже отсортированный массив.
        for (int i = 1; i < array.length; i++) {
            // Для не отсортированных элементов в отсортированном массиве ищется позиция для вставки, элементы сдвигаются
            // до тех пока не будет найдено место
            for (int j = i; j > 0 && array[j-1] > array[j]; j--) {
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
            }
        }
        return array;
    }
}
