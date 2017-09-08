package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * https://leetcode.com/problems/subsets-ii/description/
 * Created by liec on 2017-09-08.
 */
public class Solution_90_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, set, nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> set, int[] nums, int begin) {
        ans.add(new ArrayList<>(set));
        for (int i = begin; i < nums.length; i++) {
            if (begin == i || nums[i - 1] != nums[i]) {
                set.add(nums[i]);
                backtrack(ans, set, nums, i + 1);
                set.remove(set.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new Solution_90_SubsetsII()).subsetsWithDup(new int[]{1, 2, 2}).toString());
    }
}
