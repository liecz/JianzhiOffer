package leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * Created by liec on 2017-09-06.
 */
public class Solution_80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || nums[i - 2] < n) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
