package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class DecodeString {


    private int recursiveWithMemo(int index, String str) {
        // Have we already seen this substring?
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length() - 1) {
            return 1;
        }


        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str);
        }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }

    Map<Integer, Integer> memo = new HashMap<>();

    /*public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }*/

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1;

        for(int i = n-2; i >= 0 ; i--) {
            if(s.charAt(i) != 0) {
                dp[i] = dp[i+1];
                if(Integer.parseInt(s.substring(i, i+2)) <= 26)
                    dp[i] += dp[i+2];
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        DecodeString abc = new DecodeString();
        System.out.println(abc.numDecodings("2326"));
    }
}
