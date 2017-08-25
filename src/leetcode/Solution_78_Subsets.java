package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * https://leetcode.com/problems/subsets/description/
 * Created by liyue on 2017/8/23.
 */
public class Solution_78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, subset, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int s) {
        result.add(new ArrayList<>(subset));
        for (int i = s; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_78_Subsets s = new Solution_78_Subsets();
        int[] a = {1, 2, 3};
        System.out.println(s.subsets(a));
    }
}
