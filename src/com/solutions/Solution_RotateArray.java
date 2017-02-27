package com.solutions;

/**
 * 链接：https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 来源：牛客网
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * Created by liec on 17-2-8.
 */
public class Solution_RotateArray {
    public static void main(String[] args) {
        Solution_RotateArray s = new Solution_RotateArray();
        System.out.println(s.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }

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
}
