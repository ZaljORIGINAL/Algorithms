package ru.zalj.algorithms.sorts;

/**
 * Сортировка выбором - Selection Sort
 */
public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        // Прохождение по всем элементам
        for (int i = 0; i < array.length - 1; i++) {
            // Для рассматриваемого элемента ищется наименьший
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        // Буквально на позицию ищется наименьший элемент (очевидно, что на пред идущей позиции буде находится
        // элемент еще меньше)
        return array;
    }
}
