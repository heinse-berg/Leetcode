package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class MaximalSquare {

    /*public int maximalSquare(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }*/

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length, cols =  matrix[0].length, maxSquareSideLength = -1;
        int[][] dp = new int[rows][cols];

        for(int row = 0; row < rows; row++)
            if(matrix[row][0] == '1')
                dp[row][0] =1;

        for(int col = 0; col < cols; col++)
            if(matrix[col][0] == '1')
                dp[col][0] =1;

        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                if(matrix[row][col] == '1') {
                    dp[row][col] = 1 + Math.min(dp[row - 1][col - 1], Math.min(dp[row][col - 1], dp[row - 1][col]));
                    maxSquareSideLength = Math.max(maxSquareSideLength, dp[row][col]);
                }
            }
        }

        return maxSquareSideLength * maxSquareSideLength;
    }

    public static void main(String[] args) {
        MaximalSquare abc = new MaximalSquare();
        System.out.println(abc.maximalSquare(new char[][] {
                {'0','1','1','0','1'},
                {'1','0','1','1','1'},
                {'0','0','1','1','1'},
                {'0','0','1','1','1'}
        }));
    }
}
