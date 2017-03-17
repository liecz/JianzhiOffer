package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/#/description
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * Created by liec on 2017-03-17.
 */
public class Solution_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int minRow = 0, maxRow = matrix.length - 1;
        int minCol = 0, maxCol = matrix[0].length - 1;
        while (minRow <= maxRow && minCol <= maxCol) {
            for (int i = minCol; i <= maxCol; i++) {
                res.add(matrix[minRow][i]);
            }
            for (int i = minRow + 1; i <= maxRow; i++) {
                res.add(matrix[i][maxCol]);
            }
            if (minRow < maxRow) {
                for (int i = maxCol - 1; i >= minCol; i--) {
                    res.add(matrix[maxRow][i]);
                }
            }
            if (minCol < maxCol) {
                for (int i = maxRow - 1; i > minRow; i--) {
                    res.add(matrix[i][minCol]);
                }
            }
            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_SpiralMatrix s = new Solution_SpiralMatrix();
        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("s.spiralOrder(a) = " + s.spiralOrder(a));
    }
}
