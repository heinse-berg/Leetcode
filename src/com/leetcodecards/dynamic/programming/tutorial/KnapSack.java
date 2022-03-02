package com.leetcodecards.dynamic.programming.tutorial;

import java.util.Arrays;

public class KnapSack {
    int[] weights, values;
    int capacity, n;
    int[][] memo;

    /*public int dp(int i, int currWeight) {
        if(i == 0 || currWeight < 0)
            return 0;

        if(memo[i][currWeight] != -1)
            return memo[i][currWeight];

        int take = -1;
        if(currWeight - weights[i] >= 0)
            take = dp(i-1, currWeight - weights[i]) + values[i];

        int dont = dp(i-1, currWeight);

        return memo[i][currWeight] = Math.max(take, dont);
    }*/

    /*public int knap(int[] w, int[] v, int c) {
        weights = w;
        values = v;
        capacity = c; n = weights.length;
        memo = new int[n][capacity+1];

        for(int[] arr : memo)
            Arrays.fill(arr, -1);

        return dp(n-1, capacity);
    }*/

    public int bottomUp(int[] w, int[] v, int c) {
        weights = w; values = v; capacity = c; n = weights.length;
        memo = new int[n][capacity+1];

        for(int i = 1; i <= capacity ; i++)
            if(i - weights[0] >= 0)
                memo[0][i] = values[0];

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= capacity; j++) {
                int take = -1;
                if(j - weights[i] >= 0) {
                    take = memo[i - 1][j - weights[i]] + values[i];
                }
                int dont = memo[i-1][j];
                memo[i][j] = Math.max(memo[i][j], Math.max(take, dont));
            }
        }

        return memo[n-1][capacity];

    }

    public static void main(String[] args) {
        KnapSack abc = new KnapSack();

        //System.out.println(abc.knap(new int[]{5,6,7,8,9,19,10}, new int[] {1,2,3,4,5,100,7}, 20));
        System.out.println(abc.bottomUp(new int[]{5,6,7,8,9,19,10}, new int[] {1,2,3,4,5,100,7}, 20));

        for(int[] arr : abc.memo)
            System.out.println(Arrays.toString(arr));
    }
}
