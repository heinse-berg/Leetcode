package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class Interview {

    int[][] memo;
    int[] prefix;

    public int dp(int i, int a, int b, int[][] costs, int n) {

        if(i == n)
            return 0;

        if(a == n/2)
            return costs[i][1] + dp(i+1, a, b+1, costs, n);

        if(b == n/2)
            return /*memo[i][j] = */costs[i][0] + dp(i+1, a+1, b, costs, n);

/*        if(memo[i][j] != -1)
            return memo[i][j];*/

        return /*memo[i][j] = */Math.min(costs[i][0] + dp(i+1, a+1, b, costs, n), costs[i][1] + dp(i+1, a, b+1, costs, n));
    }

    public int twoCitySchedCost(int[][] costs) {

        int n = costs.length;
        for(int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

        prefix = new int[n];
        prefix[n-1] = costs[n-1][1];
        for(int i = n-2; i >= n/2; i--)
            prefix[i] = prefix[i+1] + costs[i][1];

        return dp(0, 0, 0, costs, n);
    }

    public static void main(String[] args) {
        Interview abc = new Interview();
        System.out.println(abc.twoCitySchedCost(new int[][] {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        System.out.println();
    }
}
