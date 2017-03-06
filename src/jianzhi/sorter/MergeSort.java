package jianzhi.sorter;

import java.util.Arrays;

/**
 * Created by liec on 2017-03-06.
 */
public class MergeSort {
    public static void sort(int[] array) {
        if (array == null || array.length < 2)
            return;
        int[] copy = new int[array.length];
        merge(array, copy, 0, array.length - 1);
    }

    private static void merge(int[] src, int[] copy, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) >> 1;
        merge(src, copy, low, mid);
        merge(src, copy, mid + 1, high);
        int i = low, j = mid + 1, p = i;
        while (i <= mid && j <= high) {
            if (src[i] <= src[j]) {
                copy[p++] = src[i++];
            } else {
                copy[p++] = src[j++];
            }
        }
        while (i <= mid) {
            copy[p++] = src[i++];
        }
        while (j <= high) {
            copy[p++] = src[j++];
        }
        System.arraycopy(copy, low, src, low, high - low + 1);
    }

    public static void main(String[] args) {
        int[] a = {57, 68, 59, 52, 72, 28, 96, 33, 24};
        sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }
}
