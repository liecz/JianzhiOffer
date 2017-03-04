package com.sorter;

import java.util.Arrays;

/**
 * Created by liec on 2017-03-04.
 */
public class BubbleSorter {
    public static void sort(int[] array) {
        boolean isExchanged = true;
        for (int i = 1; i < array.length && isExchanged; i++) {
            isExchanged = false;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isExchanged = true;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {57, 68, 59, 52, 72, 28, 96, 33, 24};
        sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }
}
