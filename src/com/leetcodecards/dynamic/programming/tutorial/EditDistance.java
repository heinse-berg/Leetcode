package com.leetcodecards.dynamic.programming.tutorial;

import com.playground.InputReaderFileConsole;

import java.util.*;

public class EditDistance {

    Integer[][] memo;
    int n1, n2;

    public int dp(int i, int j, String word1, String word2) {
        if(i == 0)
            return j;
        if(j == 0)
            return i;

        if(memo[i][j] != null)
            return memo[i][j];

        int down = dp(i-1, j, word1, word2)+1;
        int left = dp(i, j-1, word1, word2)+1;
        int diag = dp(i-1, j-1, word1, word2);

        if(word1.charAt(i-1) != word2.charAt(j-1))
            diag++;

        return memo[i][j] = Math.min(diag, Math.min(left, down));
    }

    public int minDistance(String word1, String word2) {
        n1 = word1.length(); n2 = word2.length();
        memo = new Integer[n1+1][n2+1];

        return dp(n1, n2, word1, word2);
    }

    /*public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length(), i, j;

        int[][] dp = new int[n1+1][n2+1];

        for(i = 0; i <= n1; i++)
            dp[i][0] = i;

        for(j = 0; j <= n2; j++)
            dp[0][j] = j;

        for(i = 1; i <= n1; i++)
            for(j = 1; j <= n2; j++) {
                int down = dp[i-1][j]+1;
                int left = dp[i][j-1]+1;
                int diag = dp[i-1][j-1];

                if(word1.charAt(i-1) != word2.charAt(j-1))
                    diag++;

                dp[i][j] = Math.min(left, Math.min(diag, down));
            }

        return dp[n1][n2];
    }*/

    public static void main(String[] args) {
        EditDistance abc = new EditDistance();
        System.out.println();
    }
}
