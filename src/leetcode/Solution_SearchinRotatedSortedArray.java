package leetcode;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/#/description
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Created by liec on 2017-03-14.
 */
public class Solution_SearchinRotatedSortedArray {
    public static void main(String[] args) {
        Solution_SearchinRotatedSortedArray s = new Solution_SearchinRotatedSortedArray();
        int[] a = {5, 1, 3};
        System.out.println(a[s.search(a, 1)]);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return -1;
        int n = nums.length;
        // 寻找数组中最小值的位置
        int lo = 0, hi = n - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) >> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int pivot = lo, realmid;
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            // 根据最小值移动数组
            realmid = (pivot + mid) % n;
            if (nums[realmid] < target) {
                lo = mid + 1;
            } else if (nums[realmid] > target) {
                hi = mid - 1;
            } else {
                return realmid;
            }
        }
        return -1;
    }
}
