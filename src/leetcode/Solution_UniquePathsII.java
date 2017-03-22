package leetcode;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/#/description
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Created by liec on 2017-03-20.
 */
public class Solution_UniquePathsII {

    /*
    * @see Solution_SpiralMatrix.java
    * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0] == null || obstacleGrid[0].length == 0)
            return 0;
        int n = obstacleGrid[0].length;
        int[] nuts = new int[n];
        nuts[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < n; i++) {
                if (row[i] == 1)
                    nuts[i] = 0;
                else if (i > 0)
                    nuts[i] += nuts[i - 1];
            }
        }
        return nuts[n - 1];
    }


    public static void main(String[] args) {
        Solution_UniquePathsII s = new Solution_UniquePathsII();
        int[][] mat = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int r = s.uniquePathsWithObstacles(mat);
        System.out.println("r = " + r);
    }
}
