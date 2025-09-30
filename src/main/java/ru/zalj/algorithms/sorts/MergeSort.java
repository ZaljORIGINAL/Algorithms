package ru.zalj.algorithms.sorts;

public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        sortPart(array, 0, array.length - 1);
        return array;
    }

    private void sortPart(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Условно делим массив на 2 части
            sortPart(arr, left, mid);
            sortPart(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Расчет длин сливаемых массивов
        int n1 = mid - left + 1;
        int n2 = right - mid;
        //Создаем копии "рассматриваемых" массивов
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        // Индексы массивов (L и R) для обходов
        int i = 0, j = 0;
        // Индекс "курсор" для основного массива
        int k = left;
        // Обход по двум массивам i - левый массив, j - правый массив
        while (i < n1 && j < n2) {
            // Если РАССМАТРИВАЕМОЕ значение "левого" массива меньше или равно,
            // ТО мы обновляем ОСНОВНОЙ массив по индексу КУРСОРУ (k) и увеличиваем индекс ЛЕВОГО МАССИВА
            // В ИНОМ СЛУЧАЕ обновляем ОСНОВНОЙ массив по индексу КУРСОРУ (k) и увеличиваем индекс ПРАВОГО МАССИВА
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Обработка ситуаций когда один из массивов был полностью пройден,
        // тогда можно утверждать, что НЕПРОЙДЕННЫЙ ДО КОНЦА МАССИВ имеет ПРЕВОСХОДЯЩИЕ ЭЛЕМЕНТЫ
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
