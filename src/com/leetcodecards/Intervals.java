package com.leetcodecards;

import java.util.*;

public class Intervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, ( (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int n = intervals.length, ans = 0;

        for(int i = 0; i < n-1; i++) {
            if(intervals[i][0] <= intervals[i+1][0] && intervals[i][1] >= intervals[i+1][1]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = intervals[i][1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Intervals abc = new Intervals();
        System.out.println();
    }
}
