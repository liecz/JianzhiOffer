package leetcode;

import java.util.Arrays;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/#/solutions
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Created by liec on 2017-03-20.
 */
public class Solution_UniquePaths {
    /*
    * DP问题
    * 由于只能向右和向下前进，所以当移动到mat[i][j]的结果：
    * mat[i][j] = mat[i-1][j] + mat[i][j-1]
    * -----------------
    * | . | . | . | . |
    * -----------------
    * | . | . | x | . |
    * -----------------
    * | . | y | * | . |
    * -----------------
    * 当需要求解*的结果时。因为只能向右和向下移动，所以结果为x+y
    * 用nut[]记录结果
    * 则x = nut[*-1], y = [*](上轮的解)
    * 故nut[m-1]为最终的解
    * */
    public int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m);
        int[] nuts = new int[m];
        Arrays.fill(nuts, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                nuts[j] += nuts[j - 1];
            }
        }
        return nuts[m - 1];
    }

    public static void main(String[] args) {
        Solution_UniquePaths s = new Solution_UniquePaths();
        int r = s.uniquePaths(3, 4);
        System.out.println("r = " + r);
    }
}
