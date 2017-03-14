package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/#/description
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * Created by liec on 2017-03-14.
 */
public class Solution_CombinationSum {
    public static void main(String[] args) {
        Solution_CombinationSum s = new Solution_CombinationSum();
        int[] a = {2, 3, 6, 7};
        List<List<Integer>> result = s.combinationSum(a, 7);
        System.out.println("result = " + result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                backtracking(candidates, remaining - candidates[i], i, result, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
