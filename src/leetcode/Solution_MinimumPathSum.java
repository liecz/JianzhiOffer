package leetcode;

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/#/description
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Created by liec on 2017-03-22.
 */
public class Solution_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int n = grid[0].length;
        int[] nuts = new int[n];
        // nuts[0],...,nuts[n-1]为移动到grid[0][0],...,grid[0][n-1]的开销
        nuts[0] = grid[0][0];
        for (int i = 1; i < n; i++)
            nuts[i] = grid[0][i] + nuts[i - 1];
        for (int i = 1; i < grid.length; i++) {
            int[] row = grid[i];
            // 移动到grid[i][0]只有一种情况
            nuts[0] += row[0];
            for (int j = 1; j < n; j++)
                // 移动到grid[i][j]的开销：grid[i][j] + min(grid[i][j-1],grid[i-1][j])
                nuts[j] = row[j] + Math.min(nuts[j - 1], nuts[j]);
        }
        return nuts[n - 1];
    }

    public static void main(String[] args) {
        Solution_MinimumPathSum s = new Solution_MinimumPathSum();
        int[][] a = new int[][]{
                {1, 1, 1},
                {1, 9, 1},
                {2, 2, 1}
        };
        int r = s.minPathSum(a);
        System.out.println("r = " + r);
    }
}
