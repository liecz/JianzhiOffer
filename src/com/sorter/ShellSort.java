package com.sorter;

import java.util.Arrays;

/**
 * Created by liec on 2017-03-04.
 */
public class ShellSort {
    public static void sort(int[] a) {
        int h = 1;
        while (h < a.length / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j - h] > a[j]; j -= h) {
                    swap(a, j - h, j);
                }
            }
            h /= 3;
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
