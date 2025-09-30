package ru.zalj.algorithms.sorts;

/**
 * Пузырьковая сортировка - Bubble Sort
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // Выражение array.length - i - 1 не позволяет затронуть часть массива, которая считается сформированной
            // (Элементы с большим значением найдены)
            for (int j = 0; j < array.length - i - 1; j++) {
                // В процессе прохождения цикла НАИБОЛЬШИЙ элемент выдавливается "наверх"
                // Если рассматриваемый элемент больше следующего, ТО меняем местами эти 2 элемента
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
