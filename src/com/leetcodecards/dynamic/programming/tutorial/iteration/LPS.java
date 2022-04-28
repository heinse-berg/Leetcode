package com.leetcodecards.dynamic.programming.tutorial.iteration;

public class LPS {

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int[] ans = new int[3];

        for(int i = 0; i < length; i++) {
            dp[i][i] = true;
            if(i+1 < length && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i + 1] = true;
                ans[0] = 2; ans[1] = i; ans[2] = i+1;
            }
        }

        for(int i = 2; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(j+i < length && s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1]) {
                    dp[j][j+i] = true;
                    if(ans[0] < i+1) {
                        ans[0] = j+i+1;
                        ans[1] = j;
                        ans[2] = j+i;
                    }
                }
            }
        }

        return s.substring(ans[1], ans[2]+1);

    }

    public static void main(String[] args) {
        System.out.println(new LPS().longestPalindrome("aaaaa"));
    }
}
