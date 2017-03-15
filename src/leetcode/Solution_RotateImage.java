package leetcode;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/#/description
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * Created by liec on 2017-03-15.
 */
public class Solution_RotateImage {
    public static void main(String[] args) {
        Solution_RotateImage s = new Solution_RotateImage();
        int[][] m = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        s.rotate(m);
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        // 矩阵行逆转
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swap(matrix, i, j, matrix.length - i - 1, j);
            }
        }
        // 求矩阵的转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] mat, int i, int j, int m, int n) {
        int t = mat[i][j];
        mat[i][j] = mat[m][n];
        mat[m][n] = t;
    }
}
