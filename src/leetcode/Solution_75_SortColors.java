package leetcode;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * <p>
 * click to show follow up.
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * <p>
 * Could you come up with an one-pass algorithm using only constant space?
 * <p>
 * Created by liyue on 2017/8/17.
 */
public class Solution_75_SortColors {

    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        if (n == 2) {
            if (nums[0] > nums[1])
                swap(nums, 0, 1);
            return;
        }
        int l = 0, r = n - 1;
        for (int i = l; i <= r; i++) {
            while (nums[i] == 2 && i < r) {
                swap(nums, i, r--);
            }
            while (nums[i] == 0 && i > l) {
                swap(nums, i, l++);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
