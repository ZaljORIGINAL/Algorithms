package ru.zalj.algorithms.sorts;

/**
 * Сортировка перемешиванием (шейкерная сортировка) - Shaker Sort
 */
public class ShakerSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int left = 0;
        int right = array.length - 1;

        // Глобально алгоритм производит распределение элементов в 2 направлениях.
        while (left < right) {
            // В процессе прохождения цикла НАИБОЛЬШИЙ элемент выдавливается "наверх"
            // Если рассматриваемый элемент больше следующего, ТО меняем местами эти 2 элемента
            for (int i = left; i < right; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            right--;

            // В процессе прохождения цикла НАИМЕНЬШИЙ элемент выдавливается "вниз"
            // Если рассматриваемый элемент меньше следующего, ТО меняем местами эти 2 элемента
            for (int i = right; i > left; i--) {
                if (array[i-1] > array[i]) {
                    int temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
            left++;
        }

        return array;
    }
}
