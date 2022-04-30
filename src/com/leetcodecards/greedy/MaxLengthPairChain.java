package com.leetcodecards.greedy;

import java.util.*;

public class MaxLengthPairChain {

    int n;

    public int dp(int[][] pairs, int i) {
        if(i == n)
            return 0;

        int ans;

        ans = dp(pairs, i+1);

        for(int j = i+1; j < n; j++) {
            if(pairs[i][1] < pairs[j][0])
                ans = dp(pairs, j) + 1;
        }

        return ans;
    }

    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        return dp(pairs, 0);
    }

    public static void main(String[] args) {
        MaxLengthPairChain m = new MaxLengthPairChain();
        System.out.println(m.findLongestChain(new int[][] {{1,3}, {4,5}, {7,8}}));
    }
}
