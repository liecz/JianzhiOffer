package leetcode;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * click to show follow up.
 * <p>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * Created by liyue on 2017/8/17.
 */
public class Solution_73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution_73_SetMatrixZeroes s = new Solution_73_SetMatrixZeroes();
        int[][] a = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        s.setZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
