package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class MinDiff {

    int[][] memo;
    int[] hardestJobLeft, jobDifficulty;
    int jobsLength, days;

    public int dp(int jobStartIndex, int currDay) {

        if(currDay == days)
            return hardestJobLeft[jobStartIndex];

        if(memo[jobStartIndex][currDay] == -1) {
            int hardestJobInIteration = -1, minDiff = Integer.MAX_VALUE;

            for(int index = jobStartIndex; index < (jobsLength-1) - (days-currDay); index++) {
                hardestJobInIteration = Math.max(hardestJobInIteration, jobDifficulty[index]);
                minDiff = Math.min(minDiff, dp(index+1, currDay+1) + hardestJobInIteration);
            }

            memo[jobStartIndex][currDay] = minDiff;
        }

        return memo[jobStartIndex][currDay];

    }

    public int minDifficulty(int[] jobDifficulty, int d) {

        this.jobsLength = jobDifficulty.length; this.days = d; this.jobDifficulty = jobDifficulty;

        if(jobsLength < d)
            return -1;

        memo = new int[jobsLength][d+1];
        for (int i = 0; i < jobsLength; i++)
            Arrays.fill(memo[i], -1);

        hardestJobLeft = new int[jobsLength];
        hardestJobLeft[jobsLength-1] = jobDifficulty[jobsLength-1];
        for(int index = jobsLength-2; index >= 0; index--)
            hardestJobLeft[index] = Math.max(hardestJobLeft[index+1], jobDifficulty[index]);

        return dp(0, 1);
    }

    public static void main(String[] args) {

        MinDiff abc = new MinDiff();
        System.out.println(abc.minDifficulty(new int[] {6,5,4,3,2,1}, 2));
    }

}
