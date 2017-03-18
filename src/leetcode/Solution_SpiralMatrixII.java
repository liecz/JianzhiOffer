package leetcode;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/#/description
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * Created by liec on 2017-03-18.
 */
public class Solution_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        if (n == 1)
            return new int[][]{{1}};
        int[][] mat = new int[n][n];
        int peel = 0, seed = 1, i, j;
        while (peel <= n - 2) {
            // →
            for (j = peel; j < n - peel; j++)
                mat[peel][j] = seed++;
            // ↓
            for (i = peel + 1; i < n - peel; i++)
                mat[i][n - peel - 1] = seed++;
            // ←
            for (j = n - peel - 2; j >= peel; j--)
                mat[n - peel - 1][j] = seed++;
            // ↑
            for (i = n - peel - 2; i > peel; i--)
                mat[i][peel] = seed++;
            peel++;
        }
        return mat;
    }

    public static void main(String[] args) {
        Solution_SpiralMatrixII s = new Solution_SpiralMatrixII();
        int n = 2;
        int[][] a = s.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
