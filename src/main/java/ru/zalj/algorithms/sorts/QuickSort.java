package ru.zalj.algorithms.sorts;

/**
 * Быстрая сортировка - Quick Sort
 */
public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        // Условное деление массива на 2 части
        if (left < right) {
            // Сортировка оригинального массива, "выдавливание" наибольшего элемента, достигаем условности,
            // что в массиве определен максимальный элемент.
            // Расчет опорного элемента для лучшего распределения
            int partitionIndex = partition(array, left, right);

            // Обработка левого под массива
            quickSort(array, left, partitionIndex - 1);
            // Обработка правого под массива
            quickSort(array, partitionIndex + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;

        return i;
    }
}
