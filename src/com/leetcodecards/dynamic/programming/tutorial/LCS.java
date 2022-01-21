package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length(), i, j;
        int[][] dp = new int[l1+1][l2+1];

        for(i = l2-1; i >= 0; i--) {
            for(j = l1-1; j >= 0 ; j--) {
                if(text2.charAt(i) == text1.charAt(j))
                    dp[j][i] = 1 + dp[j+1][i+1];
                else
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i+1]);
            }
        }
        return dp[0][0];
    }
    /*
    public int longestCommonSubsequence(String text1, String text2) {
    // Make the memo big enough to hold the cases where the pointers
    // go over the edges of the strings.
    this.memo = new int[text1.length() + 1][text2.length() + 1];
    // We need to initialise the memo array to -1's so that we know
    // whether or not a value has been filled in. Keep the base cases
    // as 0's to simplify the later code a bit.
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        this.memo[i][j] = -1;
      }
    }
    this.text1 = text1;
    this.text2 = text2;
    return memoSolve(0, 0);
  }

  private int memoSolve(int p1, int p2) {
    // Check whether or not we've already solved this subproblem.
    // This also covers the base cases where p1 == text1.length
    // or p2 == text2.length.
    if (memo[p1][p2] != -1) {
      return memo[p1][p2];
    }

    // Recursive cases.
    int answer = 0;
    if (text1.charAt(p1) == text2.charAt(p2)) {
      answer = 1 + memoSolve(p1 + 1, p2 + 1);
    } else {
      answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
    }

    // Add the best answer to the memo before returning it.
    memo[p1][p2] = answer;
    return memo[p1][p2];
  }
     */

    public static void main(String[] args) {
        LCS abc = new LCS();
        System.out.println();
    }
}
