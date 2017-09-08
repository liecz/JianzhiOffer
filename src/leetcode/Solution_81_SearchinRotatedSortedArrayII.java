package leetcode;

/**
 * 81. Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Write a function to determine if a given target is in the array.
 * <p>
 * The array may contain duplicates.
 * <p>
 * <p>
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * Created by liec on 2017-09-06.
 */
public class Solution_81_SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid;
            } else if (nums[mid] > nums[hi]) {
                if (target < nums[mid] && target >= nums[lo]) hi = mid;
                else lo = mid + 1;
            } else {
                hi--;
            }
        }
        return nums[lo] == target;
    }
}
