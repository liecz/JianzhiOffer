package com.solutions;

/**
 * Created by liec on 17-2-8.
 */
public class Solution_RotateArray {
    public int minNumberInRotateArray(int[] array) {
        int size = array.length;
        if (size == 0) {
            return 0;
        }
        int left = 0, mid = 0, right = size - 1;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                return array[right];
            }
            mid = (left + right) / 2;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                return findMin(array, left, right);
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }

    private int findMin(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_RotateArray s = new Solution_RotateArray();
        System.out.println(s.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }
}
