package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/#/description
 * Total Accepted: 103939
 * Total Submissions: 324181
 * Difficulty: Medium
 * Contributors: Admin
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Created by liec on 2017-03-15.
 */
public class Solution_CombinationSum2 {
    public static void main(String[] args) {
        Solution_CombinationSum2 s = new Solution_CombinationSum2();
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int[] b = {2, 2, 2};
        List<List<Integer>> r = s.combinationSum2(a, 8);
        System.out.println("r = " + r);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] candidates, int remaining, int start, List<List<Integer>> result, List<Integer> tmp) {
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                // 因为不复用元素，start为i+1
                backtracking(candidates, remaining - candidates[i], i + 1, result, tmp);
                tmp.remove(tmp.size() - 1);
                // 忽略和当前元素相同的元素，保证结果没有重复
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }
}
