package leetcode;

/**
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
 * elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p>
 * <p>
 * https://leetcode.com/problems/merge-sorted-array/description/
 * Created by liec on 2017-09-08.
 */
public class Solution_88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int cp = m + n - 1; cp >= 0; cp--) {
            if (p1 >= 0 && p2 >= 0) {
                nums1[cp] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
            } else if (p1 >= 0) {
                nums1[cp] = nums1[p1--];
            } else {
                nums1[cp] = nums2[p2--];
            }
        }
    }

}
