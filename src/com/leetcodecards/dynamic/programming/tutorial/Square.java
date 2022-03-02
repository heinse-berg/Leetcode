package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class Square {

    public int numSquares(int n) {
        int j = 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        LinkedList<Integer> sq = new LinkedList<>();
        sq.add(j*j);

        for(int i = 1; i <= n; i++) {
            if(i > sq.getLast())
                sq.add(++j * j);
            for(int k : sq) {
                if(i-k >= 0)
                    dp[i] = Math.min(dp[i], dp[i-k]+1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Square abc = new Square();
        System.out.println(abc.numSquares(14));
        System.out.println(abc.numSquares(12));
    }
}
