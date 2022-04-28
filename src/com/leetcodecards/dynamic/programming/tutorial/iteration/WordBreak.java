package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class WordBreak {

    /*public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                String t = s.substring(j, i);
                if (set.contains(t) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }*/

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;

        for(int i = 1; i <= length; i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[length];
    }

    public static void main(String[] args) {
        WordBreak abc = new WordBreak();
        System.out.println(abc.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
