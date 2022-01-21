package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

import static java.lang.Math.max;

public class KnapSack {
    int[] weights;
    int[] values;
    int capacity;
    int[][] dp;

    public int memo(int n, int c) {
        int val;
        if(n == 0 || c == 0)
            return 0;
        else if(dp[n][c] != 0)
            return dp[n][c];
        else if(weights[n] > c)
            val = memo(n - 1, c);
        else
            val = max(memo(n - 1, c), values[n] + memo(n - 1, c - weights[n]));
        dp[n][c] = val;
        return dp[n][c];
    }

    public int knap(int[] weights, int[] values, int capacity) {
        this.weights = weights;
        this.values = values;
        this.capacity = capacity;
        this.dp = new int[weights.length+1][capacity+1];
        return memo(4, 10);
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = max(val[i - 1] + K[i - 1][w - wt[i - 1]],
                                  K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }


    public static void main(String[] args) {
        KnapSack abc = new KnapSack();
        System.out.println(abc.knap(new int[]{5,2,4,1,3}, new int[] {5,3,6,4,2}, 10));
    }
}
