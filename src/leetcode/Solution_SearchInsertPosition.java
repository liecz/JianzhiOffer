package leetcode;

/**
 * 35 Search Insert Position
 * https://leetcode.com/problems/search-insert-position/?tab=Description
 * Given a sorted array and a target value,
 * return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * Created by liec on 2017-03-06.
 */
public class Solution_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int r = Solution_SearchInsertPosition.searchInsert(a, 3);
        System.out.println("r = " + r);
    }
}
