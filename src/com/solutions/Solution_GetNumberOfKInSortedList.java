package com.solutions;

/**
 * 统计一个数字在排序数组中出现的次数。
 * Created by liec on 2017-02-18.
 */
public class Solution_GetNumberOfKInSortedList {
    public static void main(String[] args) {
        Solution_GetNumberOfKInSortedList s = new Solution_GetNumberOfKInSortedList();
        int[] a = {1, 2, 3, 4, 4, 4, 4, 4, 5, 6};
        int b = s.GetNumberOfK(a, 4);
        System.out.println("b = " + b);
    }

    /*
    * 先使用二分查找找到k的位置，然后先前先后确定数量
    * */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int count = 0, low = 0, high = array.length - 1, mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (array[mid] > k) { // 在左边
                high = mid - 1;
            } else if (array[mid] < k) { // 在右边
                low = mid + 1;
            } else {
                int i = mid, j = mid + 1;
                while (i >= 0 && array[i--] == k) count++;
                while (j < array.length && array[j++] == k) count++;
                break;
            }
        }
        return count;
    }
}
