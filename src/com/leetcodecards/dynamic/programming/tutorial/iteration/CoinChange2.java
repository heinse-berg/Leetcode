package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class CoinChange2 {

    int target, n;
    int[][] memo;

    public int back(int index, int currSum, int[] c) {

        if(index == n || currSum > target)
            return 0;

        if(memo[index][currSum] != -1)
            return memo[index][currSum];

        if(currSum == target)
            return 1;

        int ans = 0;
        for(int i = index; i < n; i++)
            ans += back(i, currSum + c[i], c);

        return memo[index][currSum] = ans;

    }

    public int change(int amount, int[] coins) {

        target = amount;
        n = coins.length;
        memo = new int[n][amount+1];
        for(int[] m : memo)
            Arrays.fill(m, -1);

        return back(0, 0, coins);
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(5, new int[] {1,2,4}));
    }

}
