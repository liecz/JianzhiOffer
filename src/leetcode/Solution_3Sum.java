package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3 sum
 * https://leetcode.com/problems/3sum/?tab=Description
 * Given an array S of n integers, are there elements a, b, c in S such that
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Created by liec on 2017-03-06.
 */
public class Solution_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return result;
        // sort the array
        Arrays.sort(nums);
        int i = 0, j, k;
        while (i < nums.length - 2 && nums[i] <= 0) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k + 1] == nums[k]) {
                    k--;
                    continue;
                }
                int num = nums[i] + nums[j] + nums[k];
                if (num > 0) {
                    k--;
                } else if (num < 0) {
                    j++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    k--;
                }
            }
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] b = {0, 0, 0, 0, 0, 0};
        List<List<Integer>> r = Solution_3Sum.threeSum(b);
        System.out.println(r);
    }
}
