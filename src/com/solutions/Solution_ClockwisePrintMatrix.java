package com.solutions;

import java.util.ArrayList;

/**
 * Created by liec on 2017-02-13.
 */
public class Solution_ClockwisePrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return new ArrayList<>();
        }
        int rowSize=matrix.length, colSize = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>(rowSize*colSize);
        int minX = 0, minY=0, maxX = rowSize-1, maxY = colSize-1;
        while(minX<=maxX && minY<=maxY){
            for (int i = minY; i <= maxY ; i++) {
                result.add(matrix[minX][i]);
            }
            for (int i = minX+1; i <= maxX ; i++) {
                result.add(matrix[i][maxY]);
            }
            if(minX<maxX){
                for (int i = maxY-1; i >= minY; i--) {
                    result.add(matrix[maxX][i]);
                }
            }
            if(minY<maxY){
                for (int i = maxX-1; i >minX ; i--) {
                    result.add(matrix[i][minY]);
                }
            }
            minX++;
            minY++;
            maxX--;
            maxY--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        Solution_ClockwisePrintMatrix s = new Solution_ClockwisePrintMatrix();
        s.printMatrix(m);
    }
}
