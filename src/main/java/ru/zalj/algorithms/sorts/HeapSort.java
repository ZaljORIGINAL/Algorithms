package ru.zalj.algorithms.sorts;

/**
 * Пирамидальная сортировка - Heap Sort
 */
public class HeapSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        //строим приоритетную очередь и инициализируем ее заданным массивом
        int n = array.length;

        //build-heap: вызывать heapify, начиная с последнего внутреннего
        //узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(array, i--, n);
        }

        //несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            array[n - 1] = pop(array, n);
            n--;
        }
        return array;
    }

    //вернуть левого потомка `A[i]`
    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    //вернуть правого потомка `A[i]`
    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    //вспомогательная функция для замены двух индексов в массиве
    private static void swap(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    //рекурсивный алгоритм heapify-down. Узел с индексом `i` и 2 его прямых потомка нарушают свойство кучи
    private static void heapify(int[] array, int i, int size) {
        // получить левый и правый потомки узла с индексом `i`
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;

        //сравниваем `A[i]` с его левым и правым дочерними элементами и находим наибольшее значение
        if (left < size && array[left] > array[i]) largest = left;
        if (right < size && array[right] > array[largest]) largest = right;

        //поменяться местами с потомком, имеющим большее значение и вызовите heapify-down для дочернего элемента
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest, size);
        }
    }

    //функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int pop(int[] array, int size) {
        //если в куче нет элементов
        if (size <= 0) {
            return -1;
        }
        int top = array[0];

        //заменяем корень кучи последним элементом массива
        array[0] = array[size-1];
        //вызовите heapify-down на корневом узле
        heapify(array, 0, size - 1);
        return top;
    }
}
