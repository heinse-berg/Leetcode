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
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0, prev = 0;
        int[] row = new int[cols+1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = row[j];
                if (matrix[i-1][j-1] == '1') {
                    row[j] = Math.min(Math.min(row[j - 1], prev), row[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, row[j]);
                } else {
                    row[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
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
