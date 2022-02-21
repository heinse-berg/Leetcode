package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class MinDiffJob {

    public int minDifficultyBottomUp(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d)
            return -1;

        int[][] dp = new int[n][d+1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        int hardestJob;
        dp[n-1][d] = jobDifficulty[n-1];
        for(int j = n-2; j >= 0; j--)
            dp[j][d] = Math.max(jobDifficulty[j], dp[j+1][d]);

        for(int day = d-1; day > 0; day--)
            for (int i = day-1; i < n-(d-day); i++) {
                hardestJob = 0;
                for (int j = i; j < n-(d-day); j++) {
                    hardestJob = Math.max(hardestJob, jobDifficulty[j]);
                    dp[i][day] = Math.min(hardestJob + dp[j + 1][day + 1], dp[i][day]);
                }
            }

        return dp[0][1];
    }

    private int n, d;
    private int[][] memo;
    private int[] jobDifficulty;
    private int[] hardestJobRemaining;

    private int dp(int i, int day) {
        if(day == d)
            return hardestJobRemaining[i];

        if(memo[i][day] != -1)
            return memo[i][day];

        int best = Integer.MAX_VALUE;
        int hardest = 0;

        for(int j = i; j <= n-1-(d-day); j++) {
            hardest = Math.max(hardest, jobDifficulty[j]);
            best = Math.min(best, dp(j+1, day+1) + hardest);
        }

        memo[i][day] = best;

        return memo[i][day];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }

        hardestJobRemaining = new int[n];
        int hardestJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }

        memo = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        this.d = d;
        this.jobDifficulty = jobDifficulty;
        return dp(0, 1);
    }

    public static void main(String[] args) {
        MinDiffJob abc = new MinDiffJob();
        System.out.println(abc.minDifficultyBottomUp(new int[] {6,5,10,3,2,1}, 3));
    }
}
