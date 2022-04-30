package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class InterleavingStrings {

    String s1, s2, s3;
    int m, n;
    Boolean[][] memo;

    public boolean dp(int i, int j) {

        if(i == m && j == n)
            return true;

        if(memo[i][j] != null)
            return memo[i][j];

        char c1 = s1.charAt(i), c3 = s3.charAt(i + j), c2 = s2.charAt(j);

        if((i < m && c1 != c3) && (j < n && c2 != c3))
            return false;

        boolean ans = false;
        if((i < m && c1 == c3))
            ans = dp(i+1, j);

        if(!ans && (j < n && c2 == c3))
            ans = dp(i, j+1);

        return memo[i][j] = ans;

    }

    public boolean isInterleave(String s1, String s2, String s3) {

        this.s1 = s1; this.s2 = s2; this.s3 = s3;
        m = s1.length(); n = s2.length();
        memo = new Boolean[m+1][n+1];

        if(m+n != s3.length())
            return false;

        return dp(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingStrings().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
