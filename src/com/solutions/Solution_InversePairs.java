package com.solutions;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * Created by liec on 2017-02-18.
 */
public class Solution_InversePairs {
    public static void main(String[] args) {
        Solution_InversePairs s = new Solution_InversePairs();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        int b = s.InversePairs(a);
    }

    /*
    *  本题是一种归并排序的扩展，在排序过程中，前面数组是后面数组的逆序对
    *  。假设有数组{8,7,6,5,4,3,2,1},使用归并排序解决本题
    *  第一次初始：{8,7}{6,5}{4,3}{2,1}
    *  第二次初始：{7,8,5,6}{3,4,1,2} 交换得：{5,6,7,8}{1,2,3,4}
    *  第三次初始：{5,6,7,8,1,2,3,4}  交换得：{1,2,3,4,5,6,7,8}
    * */
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        int count = MergeSort(array, copy, 0, array.length - 1);
        return count;
    }

    private int MergeSort(int[] src, int[] copy, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) >> 1; // (low+high)/2
        int leftCount = MergeSort(src, copy, low, mid);
        int rightCount = MergeSort(src, copy, mid + 1, high);
        int i = mid, j = high, locCopy = high, count = 0;
        // 此时分为{}{}2段，且段内有序（增），若src[i]>src[j]那么必有
        // src[i] > src[mid+1...j] 则此时有j-mid个逆序对
        while (i >= low && j >= mid + 1) {
            if (src[i] > src[j]) {
                count += j - mid;
                copy[locCopy--] = src[i--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = src[j--];
            }
        }
        // 对剩下的元素复制
        for (; i >= low; i--)
            copy[locCopy--] = src[i];
        for (; j > mid; j--)
            copy[locCopy--] = src[j];
        // 向src拷贝
        System.arraycopy(copy, low, src, low, high - low + 1);
        return (leftCount + rightCount + count) % 1000000007;
    }
}
