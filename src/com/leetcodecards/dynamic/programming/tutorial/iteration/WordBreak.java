package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
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
    }

    public static void main(String[] args) {
        WordBreak abc = new WordBreak();
        System.out.println(abc.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
