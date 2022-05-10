package com.leetcodecards.intervals;

import java.util.*;

public class NonOverLapping {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length, ans = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        LinkedList<int[]> ni = new LinkedList<>();
        ni.addLast(intervals[0]);

        for(int i = 1; i < n; i++) {
            if(intervals[i][0] < ni.getLast()[1]) {
                ans++;
            }
            else
                ni.addLast(intervals[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
