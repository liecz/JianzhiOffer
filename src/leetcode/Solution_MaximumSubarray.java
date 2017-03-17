package leetcode;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/#/description
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * Created by liec on 2017-03-17.
 */
public class Solution_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], tsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tsum = tsum < 0 ? nums[i] : tsum + nums[i];
            sum = tsum > sum ? tsum : sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_MaximumSubarray s = new Solution_MaximumSubarray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("s.maxSubArray(a) = " + s.maxSubArray(a));
    }
}
