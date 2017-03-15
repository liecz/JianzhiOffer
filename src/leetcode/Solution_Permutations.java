package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/#/description
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * Created by liec on 2017-03-15.
 */
public class Solution_Permutations {
    public static void main(String[] args) {
        Solution_Permutations s = new Solution_Permutations();
        int[] a = {1, 2, 3};
        List<List<Integer>> r = s.permute(a);
        System.out.println("r = " + r);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        result.add(convertToList(nums));
        int len = nums.length, i, j;
        while (true) {
            i = len - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) i--;
            if (i == -1) break;
            j = i + 1;
            while (j < len && nums[i] < nums[j]) j++;
            swap(nums, i, j - 1);
            reverse(nums, i + 1);
            result.add(convertToList(nums));
        }
        return result;
    }

    private List<Integer> convertToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int a : nums)
            list.add(a);
        return list;
    }

    private void swap(int[] seq, int i, int j) {
        int t = seq[i];
        seq[i] = seq[j];
        seq[j] = t;
    }

    private void reverse(int[] seq, int i) {
        int j = seq.length - 1;
        while (i < j) {
            swap(seq, i, j);
            i++;
            j--;
        }
    }
}
