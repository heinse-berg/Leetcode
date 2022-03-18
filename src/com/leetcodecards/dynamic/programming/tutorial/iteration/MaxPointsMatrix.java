package com.leetcodecards.dynamic.programming.tutorial.iteration;

public class MaxPointsMatrix {

    Integer[][] memo;
    int[][] points;
    int m, n;

    public int dp(int currRow, int prev, int cost) {

        if(currRow == m)
            return memo[currRow][prev] =cost;

        if(memo[currRow][prev] != null)
            return memo[currRow][prev];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int currCost = cost + points[currRow][i];
            if(i != 0)
                currCost -= Math.abs(i - prev);
            int dpAns = dp(currRow+1, i, currCost);
            max = Math.max(max, dpAns);
        }

        return memo[currRow][prev] = max;
    }

    public long maxPoints(int[][] points) {
        m = points.length; n = points[0].length; this.points = points;
        memo = new Integer[m+1][n+1];
        return dp(0, 0, 0);
    }

    public static void main(String[] args) {
        MaxPointsMatrix abc = new MaxPointsMatrix();
        System.out.println(abc.maxPoints(new int[][] {{1,5}, {2,3}, {4,2}}));
        // [[1,5],[2,3],[4,2]]
    }
}
