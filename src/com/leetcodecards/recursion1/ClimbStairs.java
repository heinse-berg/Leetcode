package com.leetcodecards.recursion1;

import java.util.*;

public class ClimbStairs {

    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return climbStair(0, n, memo);
    }

    public int climbStair(int i, int n, int[] memo) {
        if(i > n)
            return 0;
        if(i == n)
            return 1;
        if(memo[i] > 0)
            return memo[i];
        memo[i] = climbStair(i+1, n, memo) + climbStair(i+2, n, memo);
        return memo[i];
    }

    public static void main(String[] args) {
        ClimbStairs abc = new ClimbStairs();
        System.out.println(abc.climbStairs(5));
    }
}
