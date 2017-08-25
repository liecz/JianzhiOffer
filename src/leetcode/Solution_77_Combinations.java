package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * https://leetcode.com/problems/combinations/description/
 * Created by liyue on 2017/8/18.
 */
public class Solution_77_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            p.add(0);
        }
        int i = 0;
        while (i >= 0) {
            p.set(i, p.get(i) + 1);
            if (p.get(i) > n) {
                i--;
            } else if (i == k - 1) {
                result.add(new ArrayList<>(p));
            } else {
                i++;
                p.set(i, p.get(i - 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_77_Combinations s = new Solution_77_Combinations();
        System.out.println(s.combine(4,2));
    }
}
