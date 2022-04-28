package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class PalindromicSubstring {

    public int countSubstrings(String s) {

        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int ans = 0;

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            if (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }

        for (int i = 2; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j + i < length && s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
