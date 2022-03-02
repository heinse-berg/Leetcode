package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class FallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, j;
        int[][] dp = new int[n][n];

        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        for(int i = 1; i < n; i++) {
            for(j = 0; j < n; j++) {
                int min = dp[i-1][j];
                if(j > 0)
                    min = Math.min(dp[i-1][j-1], min);
                if(j < n-1)
                    min = Math.min(min, dp[i-1][j+1]);

                dp[i][j] = min + matrix[i][j];
            }
        }
        int min = matrix[n-1][0];

        for(int i = 1; i < n; i++)
            min = Math.min(dp[n-1][i], min);

        return min;
    }

    public static void main(String[] args) {
        FallingPathSum abc = new FallingPathSum();
        System.out.println(abc.minFallingPathSum(new int[][] {{2,1,3},{6,5,4},{7,8,9}}));
    }
}
