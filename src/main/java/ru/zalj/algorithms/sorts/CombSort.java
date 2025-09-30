package ru.zalj.algorithms.sorts;

/**
 * Сортировка расчёской - Comb Sort
 */
public class CombSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        // Фактор разрыва посчитали умные люди
        double factor = 1.247;
        // Дельта индексов, по которым будут сравниваться индексы. Постепенно дельта будет сокращаться.
        double step = array.length - 1;

        // Минимально допустимое значение дельты 1, что сравнения соседних элементов
        while (step > 1) {
            for (int i = 0; i + step < array.length; i++) {
                // В процессе прохождения цикла НАИБОЛЬШИЙ элемент выдавливается "наверх"
                // Если рассматриваемый элемент больше следующего, ТО меняем местами эти 2 элемента
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            // Сокращение дельты
            step /= factor;
        }

        // Финальная шлифовка
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
