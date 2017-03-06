package jianzhi.sorter;

import java.util.Arrays;

/**
 * Created by liec on 2017-03-04.
 */
public class InsertSorter {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1 && array[j - 1] > array[j]; j--)
                swap(array, j - 1, j);
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
